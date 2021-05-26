package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoorLiningProperties;
import nl.infrabim.ifc.dataserver.models.IfcWindowLiningProperties;

@Service
public class IfcDoorLiningPropertiesService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcDoorLiningProperties> getAllDoorLiningProperties() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcDoorLiningProperties"));
		return mongoTemplate.find(query, IfcDoorLiningProperties.class);
	}

	public IfcDoorLiningProperties getOneDoorLiningProperties(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcDoorLiningProperties.class);
	}

}
