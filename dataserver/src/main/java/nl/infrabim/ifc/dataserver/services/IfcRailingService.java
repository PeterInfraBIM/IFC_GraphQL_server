package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRailing;

@Service
public class IfcRailingService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRailing> getAllRailings() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRailing"));
		return mongoTemplate.find(query, IfcRailing.class);
	}

	public IfcRailing getOneRailing(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRailing.class);
	}

}
