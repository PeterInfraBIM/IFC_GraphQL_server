package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcShapeRepresentation;
import nl.infrabim.ifc.dataserver.repositories.IfcShapeRepresentationRepository;

@Service
public class IfcShapeRepresentationService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcShapeRepresentationRepository shapeRepresentationRepository;

	public List<IfcShapeRepresentation> getAllShapeRepresentations() {
		List<IfcShapeRepresentation> filteredList = null;
		for (IfcShapeRepresentation candidate : shapeRepresentationRepository.findAll()) {
			if (candidate.getType().equals("IfcShapeRepresentation")) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public IfcShapeRepresentation getShapeRepresentationByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcShapeRepresentation.class);
	}

}
