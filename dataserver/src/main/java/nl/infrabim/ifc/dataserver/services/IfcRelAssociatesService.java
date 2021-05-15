package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcRelAssociatesRepository;

@Service
public class IfcRelAssociatesService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelAssociatesRepository relAssociatesRepository;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;

	public List<IfcRelAssociates> getAllRelAssociates() {
		List<IfcRelAssociates> allRelAssociates = new ArrayList<>();
		List<IfcRelAssociates> findAll = relAssociatesRepository.findAll();
		for (IfcRelAssociates candidate : findAll) {
			if (candidate.getRelatedObjectsRef() != null) {
				allRelAssociates.add(candidate);
			}
		}
		return allRelAssociates;
	}

	public IfcRelAssociates getRelAssociatesByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelAssociates.class);
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAssociates relAssociates) {
		List<IfcObjectDefinition> relatedObjects = null;
		List<Ref> relatedObjectsRef = relAssociates.getRelatedObjectsRef();
		if (relatedObjectsRef != null) {
			relatedObjects = new ArrayList<>();
			for (Ref ref : relatedObjectsRef) {
				relatedObjects.add(objectDefinitionService.getObjectDefinitionByGlobalId(ref.getRef()));
			}
		}
		return relatedObjects;
	}

}
