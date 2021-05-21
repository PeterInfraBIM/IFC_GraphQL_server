package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoor;
import nl.infrabim.ifc.dataserver.models.IfcStairFlight;
import nl.infrabim.ifc.dataserver.repositories.IfcStairFlightRepository;

@Service
public class IfcStairFlightService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcStairFlightRepository stairFlightRepository;

	public IfcDoor getOneDoor(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcDoor.class);
	}

	public List<IfcStairFlight> getAllStairFlights() {
		List<IfcStairFlight> allStairFlights = new ArrayList<>();
		List<IfcStairFlight> findAll = stairFlightRepository.findAll();
		for (IfcStairFlight candidate : findAll) {
			if (candidate.getType().equals("IfcStairFlight")) {
				allStairFlights.add(candidate);
			}
		}
		return allStairFlights;
	}

}
