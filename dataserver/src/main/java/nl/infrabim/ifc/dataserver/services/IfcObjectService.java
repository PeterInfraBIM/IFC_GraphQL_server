package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcObjectService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelDefinesByPropertiesService relDefinesByPropertiesService;

	public List<IfcObject> getAllObjects() {
		Criteria criteriaV1 = Criteria.where("isDefinedBy").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1));
		return mongoTemplate.find(query, IfcObject.class);
	}

	public IfcObject getOneObject(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcObject.class);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcObject object) {
		List<IfcRelDefinesByProperties> isDefinedBy = null;
		List<Ref> isDefinedByRef = object.getIsDefinedByRef();
		if (isDefinedByRef != null) {
			isDefinedBy = new ArrayList<>();
			for (Ref ref : isDefinedByRef) {
				IfcRelDefinesByProperties relDefinesByProperties = relDefinesByPropertiesService
						.getOneRelDefinesByProperties(ref.getRef());
				isDefinedBy.add(relDefinesByProperties);
			}
		}
		return isDefinedBy;
	}

}
