package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.repositories.IfcOpeningElementRepository;

@Service
public class IfcOpeningElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcOpeningElementRepository openingElementRepository;

	public IfcOpeningElement getOneOpeningElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcOpeningElement.class);
	}

	public List<IfcOpeningElement> getAllOpeningElements() {
		List<IfcOpeningElement> allOpeningElements = new ArrayList<>();
		List<IfcOpeningElement> findAll = openingElementRepository.findAll();
		for (IfcOpeningElement candidate : findAll) {
			if (candidate.getType().equals("IfcOpeningElement")) {
				allOpeningElements.add(candidate);
			}
		}
		return allOpeningElements;
	}

	public IfcOpeningElement getOpeningElementById(String globalId) {
		return getOneOpeningElement(globalId);
	}

}
