package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWindowLiningProperties;

@Service
public class IfcWindowLiningPropertiesService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcWindowLiningProperties> getAllWindowLiningProperties() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcWindowLiningProperties"));
		return mongoTemplate.find(query, IfcWindowLiningProperties.class);
	}

	public IfcWindowLiningProperties getOneWindowLiningProperties(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWindowLiningProperties.class);
	}

}
