package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.repositories.IfcRelFillsElementRepository;

@Service
public class IfcRelFillsElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelFillsElementRepository relFillsElementRepository;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcOpeningElementService openingElementService;

	public IfcRelFillsElement getRelFillsElementByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelFillsElement.class);
	}

	public List<IfcRelFillsElement> getAllRelFillsElements() {
		List<IfcRelFillsElement> allRelFillsElements = new ArrayList<>();
		List<IfcRelFillsElement> findAll = relFillsElementRepository.findAll();
		for (IfcRelFillsElement candidate : findAll) {
			if (candidate.getType().equals("IfcRelFillsElement")) {
				allRelFillsElements.add(candidate);
			}
		}
		return allRelFillsElements;
	}

	public IfcElement getRelatedBuildingElement(IfcRelFillsElement relFillsElement) {
		return elementService.getOneElement(relFillsElement.getRelatedBuildingElementRef().getRef());
	}

	public IfcOpeningElement getRelatingOpeningElement(IfcRelFillsElement relFillsElement) {
		return openingElementService.getOneOpeningElement(relFillsElement.getRelatingOpeningElementRef().getRef());
	}

}
