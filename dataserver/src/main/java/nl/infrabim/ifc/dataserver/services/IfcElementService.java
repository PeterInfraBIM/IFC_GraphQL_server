package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelAssociatesMaterialService relAssociatesMaterialService;
	@Autowired
	private IfcRelVoidsElementService relVoidsElementService;
	@Autowired
	private IfcRelFillsElementService relFillsElementService;

	public List<IfcElement> getAllElements() {
		Criteria criteriaV1 = Criteria.where("hasAssociations").exists(true);
		Criteria criteriaV2 = Criteria.where("hasOpenings").exists(true);
		Criteria criteriaV3 = Criteria.where("fillsVoids").exists(true);
		Criteria criteriaV4 = Criteria.where("containedInStructure").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2, criteriaV3, criteriaV4));
		return mongoTemplate.find(query, IfcElement.class);
	}

	public IfcElement getOneElement(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcElement.class);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcElement element) {
		List<IfcRelAssociatesMaterial> hasAssociations = null;
		List<Ref> hasAssociationsRef = element.getHasAssociationsRef();
		if (hasAssociationsRef != null) {
			hasAssociations = new ArrayList<>();
			for (Ref ref : hasAssociationsRef) {
				IfcRelAssociatesMaterial relAssociatesMaterial = relAssociatesMaterialService
						.getRelAssociatesMateriaByGlobalId(ref.getRef());
				hasAssociations.add(relAssociatesMaterial);
			}
		}
		return hasAssociations;
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcElement element) {
		List<IfcRelVoidsElement> hasOpenings = null;
		List<Ref> hasOpeningsRef = element.getHasOpeningsRef();
		if (hasOpeningsRef != null) {
			hasOpenings = new ArrayList<>();
			for (Ref ref : hasOpeningsRef) {
				IfcRelVoidsElement relVoidsElement = relVoidsElementService.getRelVoidsElementByGlobalId(ref.getRef());
				hasOpenings.add(relVoidsElement);
			}
		}
		return hasOpenings;
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcElement element) {
		List<IfcRelFillsElement> fillsVoids = null;
		List<Ref> fillsVoidsRef = element.getFillsVoidsRef();
		if (fillsVoidsRef != null) {
			fillsVoids = new ArrayList<>();
			for (Ref ref : fillsVoidsRef) {
				IfcRelFillsElement relFillsElement = relFillsElementService.getRelFillsElementByGlobalId(ref.getRef());
				fillsVoids.add(relFillsElement);
			}
		}
		return fillsVoids;
	}

}
