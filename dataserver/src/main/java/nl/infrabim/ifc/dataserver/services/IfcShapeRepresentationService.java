package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcGeometricRepresentationContext;
import nl.infrabim.ifc.dataserver.models.IfcShapeRepresentation;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcShapeRepresentationService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcShapeRepresentation> getAllShapeRepresentations() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcShapeRepresentation"));
		return mongoTemplate.find(query, IfcShapeRepresentation.class);
	}

	public IfcShapeRepresentation getOneShapeRepresentation(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcShapeRepresentation.class);
	}

	public List<IfcShapeRepresentation> getRepresentationsInContext(
			IfcGeometricRepresentationContext geometricRepresentationContext) {
		List<IfcShapeRepresentation> representationsInContext = null;
		List<Ref> representationsInContextRef = geometricRepresentationContext.getRepresentationsInContextRef();
		if (representationsInContextRef != null) {
			representationsInContext = new ArrayList<>();
			for (Ref ref : representationsInContextRef) {
				representationsInContext.add(getOneShapeRepresentation(ref.getRef()));
			}
		}
		return representationsInContext;
	}

}
