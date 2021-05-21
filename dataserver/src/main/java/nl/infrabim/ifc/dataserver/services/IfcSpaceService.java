package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
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
public class IfcSpaceService {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelSpaceBoundaryService relSpaceBoundaryService;

	public List<IfcSpace> getAllSpaces() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcSpace"));
		return mongoTemplate.find(query, IfcSpace.class);
	}

	public IfcSpace getOneSpace(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcSpace.class);
	}

	public List<IfcRelSpaceBoundary> getBoundedBy(IfcSpace space) {
		List<IfcRelSpaceBoundary> boundedBy = null;
		List<Ref> boundedByRef = space.getBoundedByRef();
		if (boundedByRef != null) {
			boundedBy = new ArrayList<>();
			for (Ref ref : boundedByRef) {
				boundedBy.add(relSpaceBoundaryService.getOneRelSpaceBoundary(ref.getRef()));
			}
		}
		return boundedBy;
	}

	public List<IfcElement> getBoundedByDir(IfcSpace space) {
		List<IfcElement> boundedByDir = null;
		List<Ref> boundedByRef = space.getBoundedByRef();
		if (boundedByRef != null) {
			boundedByDir = new ArrayList<>();
			for (Ref ref : boundedByRef) {
				IfcRelSpaceBoundary relSpaceBoundary = relSpaceBoundaryService.getOneRelSpaceBoundary(ref.getRef());
				boundedByDir.add(relSpaceBoundaryService.getRelatedBuildingElement(relSpaceBoundary));
			}
		}
		return boundedByDir;
	}

}
