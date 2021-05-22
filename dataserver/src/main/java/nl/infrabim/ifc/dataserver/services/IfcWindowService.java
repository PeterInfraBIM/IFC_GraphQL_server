package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWindow;

@Service
public class IfcWindowService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcWindow> getAllWindows() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcWindow"));
		return mongoTemplate.find(query, IfcWindow.class);
	}

	public IfcWindow getOneWindow(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWindow.class);
	}

}
