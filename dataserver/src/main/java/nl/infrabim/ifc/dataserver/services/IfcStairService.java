package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcStair;

@Service
public class IfcStairService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcStair> getAllStairs() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcStair"));
		return mongoTemplate.find(query, IfcStair.class);
	}

	public IfcStair getOneStair(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcStair.class);
	}

}
