package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;

@Service
public class IfcRelContainedInSpatialStructureService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRelContainedInSpatialStructure> getAllRelContainedInSpatialStructures() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelContainedInSpatialStructure"));
		return mongoTemplate.find(query, IfcRelContainedInSpatialStructure.class);
	}

	public IfcRelContainedInSpatialStructure getOneRelContainedInSpatialStructure(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelContainedInSpatialStructure.class);
	}

}
