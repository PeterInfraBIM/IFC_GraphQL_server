package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoor;

@Service
public class IfcDoorService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcDoor> getAllDoors() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcDoor"));
		return mongoTemplate.find(query, IfcDoor.class);
	}

	public IfcDoor getOneDoor(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcDoor.class);
	}

}
