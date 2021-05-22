package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcRelConnectsPathElements;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcRelConnectsPathElementsService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcElementService elementService;

	public List<IfcRelConnectsPathElements> getAllRelConnectsPathElements() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelConnectsPathElements"));
		return mongoTemplate.find(query, IfcRelConnectsPathElements.class);
	}

	public IfcRelConnectsPathElements getOneRelConnectsPathElements(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelConnectsPathElements.class);
	}

	public IfcElement getRelatingElement(IfcRelConnectsPathElements relConnectsPathElements) {
		Ref relatingElementRef = relConnectsPathElements.getRelatingElementRef();
		return relatingElementRef != null ? elementService.getOneElement(relatingElementRef.getRef()) : null;
	}

	public IfcElement getRelatedElement(IfcRelConnectsPathElements relConnectsPathElements) {
		Ref relatedElementRef = relConnectsPathElements.getRelatedElementRef();
		return relatedElementRef != null ? elementService.getOneElement(relatedElementRef.getRef()) : null;
	}

}
