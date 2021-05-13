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
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcElementRepository;

@Service
public class IfcElementService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcElementRepository elementRepository;
	@Autowired
	private IfcRelAssociatesMaterialService relAssociatesMaterialService;

	public List<IfcElement> getAllElements() {
		List<IfcElement> allElements = new ArrayList<>();
		List<IfcElement> findAll = elementRepository.findAll();
		for (IfcElement candidate : findAll) {
			if (candidate.getHasAssociationsRef() != null) {
				allElements.add(candidate);
			}
		}
		return allElements;
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

}
