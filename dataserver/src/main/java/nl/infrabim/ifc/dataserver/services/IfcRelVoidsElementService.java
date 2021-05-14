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
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.repositories.IfcRelVoidsElementRepository;

@Service
public class IfcRelVoidsElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelVoidsElementRepository relVoidsElementRepository;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcOpeningElementService openingElementService;

	public List<IfcRelVoidsElement> getAllRelVoidsElements() {
		List<IfcRelVoidsElement> allRelVoidsElement = new ArrayList<>();
		List<IfcRelVoidsElement> findAll = relVoidsElementRepository.findAll();
		for (IfcRelVoidsElement candidate : findAll) {
			if (candidate.getType().equals("IfcRelVoidsElement")) {
				allRelVoidsElement.add(candidate);
			}
		}
		return allRelVoidsElement;
	}

	public IfcRelVoidsElement getRelVoidsElementByGlobalId(String globalId) {
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
