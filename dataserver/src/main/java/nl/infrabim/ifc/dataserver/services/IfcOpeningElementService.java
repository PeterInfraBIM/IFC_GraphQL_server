package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;

@Service
public class IfcOpeningElementService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public IfcOpeningElement getOneOpeningElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcOpeningElement.class);
	}

	public List<IfcOpeningElement> getAllOpeningElements() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcOpeningElement"));
		return mongoTemplate.find(query, IfcOpeningElement.class);
	}

	public IfcOpeningElement getOpeningElementById(String globalId) {
		return getOneOpeningElement(globalId);
	}

}
