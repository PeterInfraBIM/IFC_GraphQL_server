package nl.infrabim.ifc.dataserver.services;

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
public class IfcOwnerHistoryService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcOwnerHistory> getAllOwnerHistories() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcOwnerHistory"));
		return mongoTemplate.find(query, IfcOwnerHistory.class);
	}

	public IfcOwnerHistory getOneOwnerHistory(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		IfcOwnerHistory findOne = mongoTemplate.findOne(query, IfcOwnerHistory.class);
		return findOne;
	}

	public IfcOwnerHistory getOwnerHistory(IfcRoot root) {
		Ref ownerHistoryRef = root.getOwnerHistoryRef();
		if (ownerHistoryRef != null) {
			return getOneOwnerHistory(ownerHistoryRef.getRef());
		}
		return null;
	}

}
