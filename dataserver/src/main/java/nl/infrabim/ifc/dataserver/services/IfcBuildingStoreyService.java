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
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.repositories.IfcBuildingStoreyRepository;

@Service
public class IfcBuildingStoreyService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcBuildingStoreyRepository buildingStoreyRepository;

	public List<IfcBuildingStorey> getAllBuildingStoreys() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcBuildingStorey"));
		return mongoTemplate.find(query, IfcBuildingStorey.class);
	}

	public Float getElevation(IfcBuildingStorey buildingStorey) {
		Float elevation = null;
		Optional<IfcBuildingStorey> findById = buildingStoreyRepository.findById(buildingStorey.get_Id());
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
