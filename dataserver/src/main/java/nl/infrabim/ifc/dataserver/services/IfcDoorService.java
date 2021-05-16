package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoor;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.repositories.IfcDoorRepository;
import nl.infrabim.ifc.dataserver.repositories.IfcWallStandardCaseRepository;

@Service
public class IfcDoorService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcDoorRepository doorRepository;

	public IfcDoor getOneDoor(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcDoor.class);
	}

	public List<IfcDoor> getAllDoors() {
		List<IfcDoor> allDoors = new ArrayList<>();
		List<IfcDoor> findAll = doorRepository.findAll();
		for (IfcDoor candidate : findAll) {
			if (candidate.getType().equals("IfcDoor")) {
				allDoors.add(candidate);
			}
		}
		return allDoors;
	}

}
