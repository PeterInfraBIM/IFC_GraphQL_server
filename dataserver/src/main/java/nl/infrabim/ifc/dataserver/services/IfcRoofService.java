package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRoof;

@Service
public class IfcRoofService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRoof> getAllRoofs() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRoof"));
		return mongoTemplate.find(query, IfcRoof.class);
	}

	public IfcRoof getOneRoof(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRoof.class);
	}

}
