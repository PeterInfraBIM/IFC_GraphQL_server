package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcStairFlight;

@Service
public class IfcStairFlightService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public IfcStairFlight getOneStairFlight(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcStairFlight.class);
	}

	public List<IfcStairFlight> getAllStairFlights() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcStairFlight"));
		return mongoTemplate.find(query, IfcStairFlight.class);
	}

}
