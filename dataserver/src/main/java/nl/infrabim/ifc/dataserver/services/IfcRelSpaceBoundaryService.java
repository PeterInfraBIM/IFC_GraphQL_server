package nl.infrabim.ifc.dataserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcRelSpaceBoundaryService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcSpaceService spaceService;
	@Autowired
	private IfcElementService elementService;

	public List<IfcRelSpaceBoundary> getAllRelSpaceBoundaries() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcRelSpaceBoundary"));
		return mongoTemplate.find(query, IfcRelSpaceBoundary.class);
	}

	public IfcRelSpaceBoundary getOneRelSpaceBoundary(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcRelSpaceBoundary.class);
	}

	public IfcSpace getRelatingSpace(IfcRelSpaceBoundary relSpaceBoundary) {
		Ref relatingSpaceRef = relSpaceBoundary.getRelatingSpaceRef();
		return relatingSpaceRef != null ? spaceService.getOneSpace(relatingSpaceRef.getRef()) : null;
	}

	public IfcElement getRelatedBuildingElement(IfcRelSpaceBoundary relSpaceBoundary) {
		Ref relatedBuildingElementRef = relSpaceBoundary.getRelatedBuildingElementRef();
		return relatedBuildingElementRef != null ? elementService.getOneElement(relatedBuildingElementRef.getRef())
				: null;
	}

}
