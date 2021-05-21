package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;

@Service
public class IfcWallStandardCaseService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcWallStandardCase> getAllWallStandardCases() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcWallStandardCase"));
		return mongoTemplate.find(query, IfcWallStandardCase.class);
	}

	public IfcWallStandardCase getOneWallStandardCase(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWallStandardCase.class);
	}

}
