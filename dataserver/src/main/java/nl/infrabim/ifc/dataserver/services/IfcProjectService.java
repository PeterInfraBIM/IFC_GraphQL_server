package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcGeometricRepresentationContext;
import nl.infrabim.ifc.dataserver.models.IfcProject;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcProjectService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcProject> getAllProjects() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcProject"));
		return mongoTemplate.find(query, IfcProject.class);
	}

	public IfcProject getOneProject(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcProject.class);
	}

	public List<IfcGeometricRepresentationContext> getRepresentationContexts(IfcProject project) {
		List<IfcGeometricRepresentationContext> representationContexts = null;
		List<Ref> representationContextsRef = project.getRepresentationContextsRef();
		if (representationContextsRef != null) {
			representationContexts = new ArrayList<>();
			for (Ref ref : representationContextsRef) {
				Query query = new Query();
				query.addCriteria(Criteria.where("globalId").is(ref.getRef()));
				representationContexts.add(mongoTemplate.findOne(query, IfcGeometricRepresentationContext.class));
			}
		}
		return representationContexts;
	}

}
