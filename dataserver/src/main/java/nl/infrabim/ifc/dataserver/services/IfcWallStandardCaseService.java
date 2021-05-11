package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.repositories.IfcWallStandardCaseRepository;

@Service
public class IfcWallStandardCaseService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcWallStandardCaseRepository wallStandardCaseRepository;

	public List<IfcWallStandardCase> getAllWallStandardCases() {
		List<IfcWallStandardCase> allWallStandardCases = new ArrayList<>();
		List<IfcWallStandardCase> findAll = wallStandardCaseRepository.findAll();
		for (IfcWallStandardCase candidate : findAll) {
			if (candidate.getType().equals("IfcWallStandardCase")) {
				allWallStandardCases.add(candidate);
			}
		}
		return allWallStandardCases;
	}

	public IfcWallStandardCase getOneWallStandardCase(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcWallStandardCase.class);
	}

}
