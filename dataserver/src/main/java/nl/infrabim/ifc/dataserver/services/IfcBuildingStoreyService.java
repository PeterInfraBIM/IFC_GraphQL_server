package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.repositories.IfcBuildingStoreyRepository;

@Service
public class IfcBuildingStoreyService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcBuildingStoreyRepository buildingStoreyRepository;

	public List<IfcBuildingStorey> getAllBuildingStoreys() {
		List<IfcBuildingStorey> allBuildingStoreys = new ArrayList<>();
		List<IfcBuildingStorey> findAll = buildingStoreyRepository.findAll();
		for (IfcBuildingStorey candidate : findAll) {
			if (candidate.getType().equals("IfcBuildingStorey")) {
				allBuildingStoreys.add(candidate);
			}
		}
		return allBuildingStoreys;
	}

	public Float getElevation(IfcBuildingStorey buildingStorey) {
		Float elevation = null;
		Optional<IfcBuildingStorey> findById = buildingStoreyRepository.findById(buildingStorey.getId());
		if (findById.isPresent()) {
			elevation = findById.get().getElevation();
		}
		return elevation;
	}

	public IfcBuildingStorey getOneBuildingStorey(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcBuildingStorey.class);
	}

}
