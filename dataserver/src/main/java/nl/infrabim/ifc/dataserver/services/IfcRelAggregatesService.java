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
public class IfcRelAggregatesService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;

	public List<IfcRelAggregates> getAllRelAggregates() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelAggregates"));
		return mongoTemplate.find(query, IfcRelAggregates.class);
	}

	public IfcRelAggregates getOneRelAggregates(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelAggregates.class);
	}

	public IfcObjectDefinition getRelatingObject(IfcRelAggregates relAggregates) {
		Ref relatingObjectRef = relAggregates.getRelatingObjectRef();
		return relatingObjectRef != null
				? objectDefinitionService.getOneObjectDefinition(relatingObjectRef.getRef())
				: null;
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAggregates relAggregates) {
		List<IfcObjectDefinition> relatedObjects = null;
		List<Ref> relatedObjectsRef = relAggregates.getRelatedObjectsRef();
		if (relatedObjectsRef != null) {
			relatedObjects = new ArrayList<>();
			for (Ref ref : relatedObjectsRef) {
				relatedObjects.add(objectDefinitionService.getOneObjectDefinition(ref.getRef()));
			}
		}
		return relatedObjects;
	}

}
