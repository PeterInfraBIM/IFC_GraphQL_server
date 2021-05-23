package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWall;

@Service
public class IfcWallService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcWall> getAllWalls() {
		Criteria criteriaV1 = Criteria.where("type").is("IfcWall");
		Criteria criteriaV2 = Criteria.where("type").is("IfcWallStandardCase");
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2));
		return mongoTemplate.find(query, IfcWall.class);
	}

	public IfcWall getOneWall(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWall.class);
	}

}
