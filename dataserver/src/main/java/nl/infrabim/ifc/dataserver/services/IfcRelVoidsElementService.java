package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;

@Service
public class IfcRelVoidsElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcOpeningElementService openingElementService;

	public List<IfcRelVoidsElement> getAllRelVoidsElements() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelVoidsElement"));
		return mongoTemplate.find(query, IfcRelVoidsElement.class);
	}

	public IfcRelVoidsElement getOneRelVoidsElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelVoidsElement.class);
	}

	public IfcElement getRelatingBuildingElement(IfcRelVoidsElement relVoidsElement) {
		return elementService.getOneElement(relVoidsElement.getRelatingBuildingElementRef().getRef());
	}

	public IfcOpeningElement getRelatedOpeningElement(IfcRelVoidsElement relVoidsElement) {
		return openingElementService.getOneOpeningElement(relVoidsElement.getRelatedOpeningElementRef().getRef());
	}

}
