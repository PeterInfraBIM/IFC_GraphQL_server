package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcGeometricRepresentationContext;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProject;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProjectService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcProjectResolver implements GraphQLResolver<IfcProject> {

	@Autowired
	private IfcProjectService projectService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcProject project) {
		return rootService.getOwnerHistory(project);
	}

	public List<Ref> getIsDecomposedByRef(IfcProject project) {
		return objectDefinitionService.getIsDecomposedByRef(project);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcProject project) {
		return objectDefinitionService.getIsDecomposedBy(project);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcProject project) {
		return objectDefinitionService.getIsDecomposedByDir(project);
	}

	public List<Ref> getDecomposesRef(IfcProject project) {
		return objectDefinitionService.getDecomposesRef(project);
	}

	public List<IfcRelAggregates> getDecomposes(IfcProject project) {
		return objectDefinitionService.getDecomposes(project);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcProject project) {
		return objectDefinitionService.getDecomposesDir(project);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcProject project) {
		return objectService.getIsDefinedBy(project);
	}

	public List<IfcGeometricRepresentationContext> getRepresentationContexts(IfcProject project) {
		return projectService.getRepresentationContexts(project);
	}
}
