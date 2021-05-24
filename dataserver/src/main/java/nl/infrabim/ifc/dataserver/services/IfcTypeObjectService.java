package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoorStyle;
import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcTypeObjectService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelDefinesByTypeService relDefinesByTypeService;

	public List<IfcTypeObject> getAllTypeObjects() {
		Criteria criteriaV1 = Criteria.where("hasPropertySets").exists(true);
		Criteria criteriaV2 = Criteria.where("objectTypeOf").exists(true);
		Criteria criteriaV3 = Criteria.where("applicableOccurrence").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2, criteriaV3));
		return mongoTemplate.find(query, IfcTypeObject.class);
	}

	public IfcTypeObject getOneTypeObject(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcTypeObject.class);
	}

	public List<IfcRelDefinesByType> getObjectTypeOf(IfcDoorStyle doorStyle) {
		List<IfcRelDefinesByType> objectTypeOf = null;
		List<Ref> objectTypeOfRef = doorStyle.getObjectTypeOfRef();
		if (objectTypeOfRef != null) {
			objectTypeOf = new ArrayList<>();
			for (Ref ref : objectTypeOfRef) {
				IfcRelDefinesByType relDefinesByType = relDefinesByTypeService.getOneRelDefinesByType(ref.getRef());
				objectTypeOf.add(relDefinesByType);
			}
		}
		return objectTypeOf;
	}
	
	public List<IfcObject> getObjectTypeOfDir(IfcDoorStyle doorStyle) {
		List<IfcObject> objects = null;
		List<IfcRelDefinesByType> objectTypeOf = getObjectTypeOf(doorStyle);
		if (objectTypeOf != null) {
			objects = new ArrayList<>();
			for (IfcRelDefinesByType relDefinesByType : objectTypeOf) {
				List<IfcObject> relatedObjects = relDefinesByTypeService.getRelatedObjects(relDefinesByType);
				objects.addAll(relatedObjects);
			}
		}
		return objects;
	}

}
