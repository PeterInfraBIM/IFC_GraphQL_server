package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcRootService {

	@Autowired
	private IfcOwnerHistoryService ownerHistoryService;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcRoot> getAllRoots() {
		Criteria criteriaV1 = Criteria.where("ownerHistory").exists(true);
		Criteria criteriaV2 = Criteria.where("name").exists(true);
		Criteria criteriaV3 = Criteria.where("description").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2, criteriaV3));
		return mongoTemplate.find(query, IfcRoot.class);
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

	public IfcRoot getOneRoot(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRoot.class);
	}

	public IfcOwnerHistory getOwnerHistory(IfcRoot root) {
		Ref ownerHistoryRef = root.getOwnerHistoryRef();
		if (ownerHistoryRef != null) {
			return ownerHistoryService.getOneOwnerHistory(ownerHistoryRef.getRef());
		}
		return null;
	}

}
