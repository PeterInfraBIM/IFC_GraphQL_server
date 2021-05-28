package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcPropertyDefinition;
import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcPropertyDefinitionService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelAssociatesService relAssociatesService;

	public IfcPropertyDefinition getOnePropertyDefinition(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcPropertyDefinition.class);
	}

	public List<IfcRelAssociates> getHasAssociations(IfcPropertySetDefinition propertySetDefinition) {
		List<IfcRelAssociates> hasAssociations = null;
		List<Ref> hasAssociationsRef = propertySetDefinition.getHasAssociationsRef();
		if (hasAssociationsRef != null) {
			hasAssociations = new ArrayList<>();
			for (Ref ref : hasAssociationsRef) {
				hasAssociations.add(relAssociatesService.getOneRelAssociates(ref.getRef()));
			}
		}
		return hasAssociations;
	}
}
