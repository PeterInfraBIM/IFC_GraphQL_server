package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcRelDefinesByTypeService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcObjectService objectService;

	public List<IfcRelDefinesByType> getAllRelDefinesByTypes() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelDefinesByProperties"));
		return mongoTemplate.find(query, IfcRelDefinesByType.class);
	}

	public IfcRelDefinesByType getOneRelDefinesByType(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelDefinesByType.class);
	}

	public List<IfcObject> getRelatedObjects(IfcRelDefinesByType relDefinesByType) {
		List<IfcObject> objects = null;
		List<Ref> relatedObjectsRef = relDefinesByType.getRelatedObjectsRef();
		if (relatedObjectsRef != null) {
			objects = new ArrayList<>();
			for (Ref relatedObject : relatedObjectsRef) {
				objects.add(objectService.getOneObject(relatedObject.getRef()));
			}
		}
		return objects;
	}

}
