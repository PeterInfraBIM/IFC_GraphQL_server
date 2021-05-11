package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.repositories.IfcBuildingRepository;

@Service
public class IfcBuildingService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcBuildingRepository buildingRepository;

	public List<IfcBuilding> getAllBuildings() {
		List<IfcBuilding> allBuildings = new ArrayList<>();
		List<IfcBuilding> findAll = buildingRepository.findAll();
		for (IfcBuilding candidate : findAll) {
			if (candidate.getType().equals("IfcBuilding")) {
				allBuildings.add(candidate);
			}
		}
		return allBuildings;
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
