package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcDoorStyle;

@Service
public class IfcDoorStyleService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcDoorStyle> getAllDoorStyles() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcDoorStyle"));
		return mongoTemplate.find(query, IfcDoorStyle.class);
	}

	public IfcDoorStyle getOneDoorStyle(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcDoorStyle.class);
	}

}
