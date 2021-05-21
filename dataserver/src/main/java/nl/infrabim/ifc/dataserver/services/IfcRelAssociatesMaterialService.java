package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;

@Service
public class IfcRelAssociatesMaterialService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRelAssociatesMaterial> getAllRelAssociatesMaterials() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelAssociatesMaterial"));
		return mongoTemplate.find(query, IfcRelAssociatesMaterial.class);
	}

	public IfcRelAssociatesMaterial getRelAssociatesMateriaByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelAssociatesMaterial.class);
	}

}
