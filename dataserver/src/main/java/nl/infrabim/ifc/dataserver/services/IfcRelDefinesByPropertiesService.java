package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.repositories.IfcRelDefinesByPropertiesRepository;

@Service
public class IfcRelDefinesByPropertiesService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelDefinesByPropertiesRepository relDefinesByPropertiesRepository;

	public List<IfcRelDefinesByProperties> getAllRelDefinesByProperties() {
		List<IfcRelDefinesByProperties> allRelDefinesByProperties = new ArrayList<>();
		List<IfcRelDefinesByProperties> findAll = relDefinesByPropertiesRepository.findAll();
		for (IfcRelDefinesByProperties candidate : findAll) {
			if (candidate.getType().equals("IfcRelDefinesByProperties")) {
				allRelDefinesByProperties.add(candidate);
			}
		}
		return allRelDefinesByProperties;
	}

	public IfcRelDefinesByProperties getRelDefinesByPropertiesByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelDefinesByProperties.class);
	}

}
