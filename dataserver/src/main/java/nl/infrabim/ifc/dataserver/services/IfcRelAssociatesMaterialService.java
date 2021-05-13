package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.repositories.IfcRelAssociatesMaterialRepository;

@Service
public class IfcRelAssociatesMaterialService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelAssociatesMaterialRepository relAssociatesMaterialRepository;

	public List<IfcRelAssociatesMaterial> getAllRelAssociatesMaterials() {
		List<IfcRelAssociatesMaterial> allRelAssociatesMaterials = new ArrayList<>();
		List<IfcRelAssociatesMaterial> findAll = relAssociatesMaterialRepository.findAll();
		for (IfcRelAssociatesMaterial candidate : findAll) {
			if (candidate.getType().equals("IfcRelAssociatesMaterial")) {
				allRelAssociatesMaterials.add(candidate);
			}
		}
		return allRelAssociatesMaterials;
	}

	public IfcRelAssociatesMaterial getRelAssociatesMateriaByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelAssociatesMaterial.class);
	}

}
