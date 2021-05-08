package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcRelAggregatesRepository;

@Service
public class IfcRelAggregatesService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private IfcRootService rootService;

	@Autowired
	private IfcRelAggregatesRepository relAggregatesRepository;

	public List<IfcRelAggregates> getAllRelAggregates() {
		List<IfcRelAggregates> allRelAggregates = null;
		List<IfcRoot> filterRootsByType = rootService.filterRootsByType("IfcRelAggregates");
		if (filterRootsByType != null) {
			allRelAggregates = new ArrayList<>();
			for (IfcRoot r : filterRootsByType) {
				IfcRelAggregates s = new IfcRelAggregates();
				s.copyRootValues(r);
				allRelAggregates.add(s);
			}
		}
		return allRelAggregates;
	}

	public IfcRelAggregates getRelAggregatesByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelAggregates.class);
	}

	public Ref getRelatingObjectRef(IfcRelAggregates relAggregates) {
		Optional<IfcRelAggregates> findById = relAggregatesRepository.findById(relAggregates.getId());
		if (findById.isPresent()) {
			return findById.get().getRelatingObjectRef();
		}
		return null;
	}

	public IfcRoot getRelatingObject(IfcRelAggregates relAggregates) {
		Optional<Ref> ref = Optional.ofNullable(getRelatingObjectRef(relAggregates));
		if (ref.isPresent()) {
			return rootService.getRootByGlobalId(ref.get().getRef());
		}
		return null;
	}

	public List<Ref> getRelatedObjectsRef(IfcRelAggregates relAggregates) {
		Optional<IfcRelAggregates> findById = relAggregatesRepository.findById(relAggregates.getId());
		if (findById.isPresent()) {
			return findById.get().getRelatedObjectsRef();
		}
		return null;
	}

	public List<IfcRoot> getRelatedObjects(IfcRelAggregates relAggregates) {
		List<IfcRoot> relatedObjects = null;
		Optional<List<Ref>> refList = Optional.ofNullable(getRelatedObjectsRef(relAggregates));
		if (refList.isPresent()) {
			relatedObjects = new ArrayList<>();
			List<Ref> relatedObjectsRef = refList.get();
			for (Ref ref : relatedObjectsRef) {
				relatedObjects.add(rootService.getRootByGlobalId(ref.getRef()));
			}
		}
		return relatedObjects;
	}

}
