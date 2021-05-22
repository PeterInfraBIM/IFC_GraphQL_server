package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;

@Service
public class IfcRelDefinesByPropertiesService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRelDefinesByProperties> getAllRelDefinesByProperties() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelDefinesByProperties"));
		return mongoTemplate.find(query, IfcRelDefinesByProperties.class);
	}

	public IfcRelDefinesByProperties getOneRelDefinesByProperties(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelDefinesByProperties.class);
	}

}
