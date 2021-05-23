package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBeam;

@Service
public class IfcBeamService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcBeam> getAllBeams() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcBeam"));
		return mongoTemplate.find(query, IfcBeam.class);
	}

	public IfcBeam getOneBeam(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcBeam.class);
	}

}
