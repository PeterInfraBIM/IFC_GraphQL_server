package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcMember;

@Service
public class IfcMemberService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcMember> getAllMembers() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcMember"));
		return mongoTemplate.find(query, IfcMember.class);
	}

	public IfcMember getOneMember(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcMember.class);
	}

}
