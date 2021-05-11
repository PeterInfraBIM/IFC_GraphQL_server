package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.repositories.IfcRootRepository;

@Service
public class IfcRootService {

	@Autowired
	private IfcRootRepository rootRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRoot> getAllRoots() {
		List<IfcRoot> filteredList = null;
		for (IfcRoot candidate : rootRepository.findAll()) {
			if (candidate.getName() != null || candidate.getDescription() != null) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public List<IfcRoot> filterRootsByType(String filterType) {
		List<IfcRoot> filteredList = null;
		for (IfcRoot root : getAllRoots()) {
			if (root.getType().equals(filterType)) {
				if (filteredList == null) {
					filteredList = new ArrayList<>();
				}
				filteredList.add(root);
			}
		}
		return filteredList;
	}

	public IfcRoot getRootByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRoot.class);
	}

}
