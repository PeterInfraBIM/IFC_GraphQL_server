package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcFooting;

@Service
public class IfcFootingService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcFooting> getAllFootings() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcFooting"));
		return mongoTemplate.find(query, IfcFooting.class);
	}

	public IfcFooting getOneFooting(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcFooting.class);
	}

}
