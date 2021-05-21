package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;

@Service
public class IfcBuildingService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcBuilding> getAllBuildings() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcBuilding"));
		return mongoTemplate.find(query, IfcBuilding.class);
	}

	public IfcBuilding getOneBuilding(String globalId) {
		return getBuildingByGlobalId(globalId);
	}

	public IfcBuilding getBuildingByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcBuilding.class);
	}

}
