package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcObjectDefinitionService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcRelAggregatesService relAggregatesService;

	public List<IfcObjectDefinition> getAllObjectDefinitions() {
		Criteria criteriaV1 = Criteria.where("isDecomposedBy").exists(true);
		Criteria criteriaV2 = Criteria.where("decomposes").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2));
		return mongoTemplate.find(query, IfcObjectDefinition.class);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcObjectDefinition objectDefinition) {
		List<IfcRelAggregates> isDecomposedBy = null;
		List<Ref> isDecomposedByRef = objectDefinition.getIsDecomposedByRef();
		if (isDecomposedByRef != null) {
			isDecomposedBy = new ArrayList<>();
			for (Ref ref : isDecomposedByRef) {
				isDecomposedBy.add(relAggregatesService.getOneRelAggregates(ref.getRef()));
			}
		}
		return isDecomposedBy;
	}

	public List<IfcRelAggregates> getDecomposes(IfcObjectDefinition objectDefinition) {
		List<IfcRelAggregates> decomposes = null;
		List<Ref> decomposesRef = objectDefinition.getDecomposesRef();
		if (decomposesRef != null) {
			decomposes = new ArrayList<>();
			for (Ref ref : decomposesRef) {
				decomposes.add(relAggregatesService.getOneRelAggregates(ref.getRef()));
			}
		}
		return decomposes;
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcObjectDefinition objectDefinition) {
		List<IfcObjectDefinition> isDecomposedByDir = null;
		List<IfcRelAggregates> isDecomposedBy = getIsDecomposedBy(objectDefinition);
		if (isDecomposedBy != null) {
			isDecomposedByDir = new ArrayList<>();
			for (IfcRelAggregates rel : isDecomposedBy) {
				List<Ref> relatedObjectsRef = rel.getRelatedObjectsRef();
				for (Ref ref : relatedObjectsRef) {
					isDecomposedByDir.add(objectDefinitionService.getOneObjectDefinition(ref.getRef()));
				}
			}
		}
		return isDecomposedByDir;
	}

	public IfcObjectDefinition getOneObjectDefinition(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcObjectDefinition.class);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcObjectDefinition objectDefinition) {
		List<IfcObjectDefinition> decomposesDir = null;
		List<IfcRelAggregates> decomposes = getDecomposes(objectDefinition);
		if (decomposes != null) {
			decomposesDir = new ArrayList<>();
			for (IfcRelAggregates rel : decomposes) {
				Ref relatedObjectsRef = rel.getRelatingObjectRef();
				decomposesDir.add(getOneObjectDefinition(relatedObjectsRef.getRef()));
			}
		}
		return decomposesDir;
	}

}
