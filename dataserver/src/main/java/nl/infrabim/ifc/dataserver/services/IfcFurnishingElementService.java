package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcFurnishingElement;

@Service
public class IfcFurnishingElementService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcFurnishingElement> getAllFurnishingElements() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcFurnishingElement"));
		return mongoTemplate.find(query, IfcFurnishingElement.class);
	}

	public IfcFurnishingElement getOneFurnishingElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcFurnishingElement.class);
	}

}
