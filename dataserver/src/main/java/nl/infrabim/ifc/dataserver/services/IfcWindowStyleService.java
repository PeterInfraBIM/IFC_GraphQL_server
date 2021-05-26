package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWindowStyle;

@Service
public class IfcWindowStyleService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcWindowStyle> getAllWindowStyles() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcWindowStyle"));
		return mongoTemplate.find(query, IfcWindowStyle.class);
	}

	public IfcWindowStyle getOneWindowStyle(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWindowStyle.class);
	}

}
