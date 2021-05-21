package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;

@Service
public class IfcBuildingStoreyService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcBuildingStorey> getAllBuildingStoreys() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcBuildingStorey"));
		return mongoTemplate.find(query, IfcBuildingStorey.class);
	}

	public IfcBuildingStorey getOneBuildingStorey(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcBuildingStorey.class);
	}

}
