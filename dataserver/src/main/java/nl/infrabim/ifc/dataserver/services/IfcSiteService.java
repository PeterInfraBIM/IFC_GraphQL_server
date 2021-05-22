package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcSite;

@Service
public class IfcSiteService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcSite> getAllSites() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcSite"));
		return mongoTemplate.find(query, IfcSite.class);
	}
	
	public IfcSite getOneSite(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcSite.class);
	}


}
