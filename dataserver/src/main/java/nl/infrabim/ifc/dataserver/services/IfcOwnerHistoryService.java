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
import nl.infrabim.ifc.dataserver.repositories.IfcOwnerHistoryRepository;

@Service
public class IfcOwnerHistoryService {

	@Autowired
	private IfcOwnerHistoryRepository ownerHistoryRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcOwnerHistory> getAllOwnerHistories() {
		List<IfcOwnerHistory> filteredList = null;
		for (IfcOwnerHistory candidate : ownerHistoryRepository.findAll()) {
			if (candidate.getType().equals("IfcOwnerHistory")) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public IfcOwnerHistory getOwnerHistoryByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		IfcOwnerHistory findOne = mongoTemplate.findOne(query, IfcOwnerHistory.class);
		return findOne;
	}

	public IfcOwnerHistory getOwnerHistory(IfcRoot root) {
		Ref ownerHistoryRef = root.getOwnerHistoryRef();
		if (ownerHistoryRef != null) {
			return getOwnerHistoryByGlobalId(ownerHistoryRef.getRef());
		}
		return null;
	}

}
