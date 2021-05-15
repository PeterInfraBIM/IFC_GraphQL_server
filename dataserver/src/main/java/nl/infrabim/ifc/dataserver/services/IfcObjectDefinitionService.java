package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcObjectDefinitionRepository;

@Service
public class IfcObjectDefinitionService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcObjectDefinitionRepository objectDefinitionRepository;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcRelAggregatesService relAggregatesService;

	public List<IfcObjectDefinition> getAllObjectDefinitions() {
		List<IfcObjectDefinition> filteredList = null;
		for (IfcObjectDefinition candidate : objectDefinitionRepository.findAll()) {
			if (candidate.getDecomposesRef() != null || candidate.getIsDecomposedByRef() != null) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public List<Ref> getIsDecomposedByRef(IfcObjectDefinition objectDefinition) {
		Optional<IfcObjectDefinition> findById = objectDefinitionRepository.findById(objectDefinition.get_Id());
		if (findById.isPresent()) {
			return findById.get().getIsDecomposedByRef();
		}
		return null;
	}

	public List<Ref> getDecomposesRef(IfcObjectDefinition objectDefinition) {
		Optional<IfcObjectDefinition> findById = objectDefinitionRepository.findById(objectDefinition.get_Id());
		if (findById.isPresent()) {
			return findById.get().getDecomposesRef();
		}
		return null;
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcObjectDefinition objectDefinition) {
		List<IfcRelAggregates> isDecomposedBy = null;
		Optional<List<Ref>> refList = Optional.ofNullable(getIsDecomposedByRef(objectDefinition));
		if (refList.isPresent()) {
			isDecomposedBy = new ArrayList<>();
			List<Ref> relatedObjectsRef = refList.get();
			for (Ref ref : relatedObjectsRef) {
				isDecomposedBy.add(relAggregatesService.getRelAggregatesByGlobalId(ref.getRef()));
			}
		}
		return isDecomposedBy;
	}

	public List<IfcRelAggregates> getDecomposes(IfcObjectDefinition objectDefinition) {
		List<IfcRelAggregates> decomposes = null;
		Optional<List<Ref>> refList = Optional.ofNullable(getDecomposesRef(objectDefinition));
		if (refList.isPresent()) {
			decomposes = new ArrayList<>();
			List<Ref> relatingObjectRef = refList.get();
			for (Ref ref : relatingObjectRef) {
				decomposes.add(relAggregatesService.getRelAggregatesByGlobalId(ref.getRef()));
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
					isDecomposedByDir.add(objectDefinitionService.getObjectDefinitionByGlobalId(ref.getRef()));
				}
			}
		}
		return isDecomposedByDir;
	}

	public IfcObjectDefinition getObjectDefinitionByGlobalId(String globalId) {
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
				decomposesDir.add(getObjectDefinitionByGlobalId(relatedObjectsRef.getRef()));
			}
		}
		return decomposesDir;
	}

}
