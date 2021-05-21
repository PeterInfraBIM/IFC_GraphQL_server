package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcRelContainedInSpatialStructureRepository;

@Service
public class IfcRelContainedInSpatialStructureService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private IfcRelContainedInSpatialStructureRepository relContainedInSpatialStructureRepository;

	public List<IfcRelContainedInSpatialStructure> getAllRelContainedInSpatialStructures() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelContainedInSpatialStructure"));
		return mongoTemplate.find(query, IfcRelContainedInSpatialStructure.class);
	}

	public Ref getRelatingStructure(IfcRelContainedInSpatialStructure relContainedInSpatialStructure) {
		Optional<IfcRelContainedInSpatialStructure> findById = relContainedInSpatialStructureRepository
				.findById(relContainedInSpatialStructure.get_Id());
		if (findById.isPresent()) {
			return findById.get().getRelatingStructure();
		}
		return null;
	}

	public List<Ref> getRelatedElements(IfcRelContainedInSpatialStructure relContainedInSpatialStructure) {
		Optional<IfcRelContainedInSpatialStructure> findById = relContainedInSpatialStructureRepository
				.findById(relContainedInSpatialStructure.get_Id());
		if (findById.isPresent()) {
			return findById.get().getRelatedElements();
		}
		return null;
	}

	public IfcRelContainedInSpatialStructure getRelContainedInSpatialStructureByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelContainedInSpatialStructure.class);
	}

}
