package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcSlab;

@Service
public class IfcSlabService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public IfcSlab getOneSlab(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcSlab.class);
	}

	public List<IfcSlab> getAllSlabs() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcSlab"));
		return mongoTemplate.find(query, IfcSlab.class);
	}

}
