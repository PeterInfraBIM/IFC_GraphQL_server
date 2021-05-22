package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;

@Service
public class IfcRelFillsElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcOpeningElementService openingElementService;

	public IfcRelFillsElement getOneRelFillsElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelFillsElement.class);
	}

	public List<IfcRelFillsElement> getAllRelFillsElements() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelFillsElement"));
		return mongoTemplate.find(query, IfcRelFillsElement.class);
	}

	public IfcElement getRelatedBuildingElement(IfcRelFillsElement relFillsElement) {
		return elementService.getOneElement(relFillsElement.getRelatedBuildingElementRef().getRef());
	}

	public IfcOpeningElement getRelatingOpeningElement(IfcRelFillsElement relFillsElement) {
		return openingElementService.getOneOpeningElement(relFillsElement.getRelatingOpeningElementRef().getRef());
	}

}
