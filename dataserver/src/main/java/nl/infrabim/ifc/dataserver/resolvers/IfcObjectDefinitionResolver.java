package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcObjectDefinitionResolver implements GraphQLResolver<IfcObjectDefinition> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcObjectDefinition objectDefinition) {
		return rootService.getOwnerHistory(objectDefinition);
	}

	public List<Ref> getIsDecomposedByRef(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getIsDecomposedByRef(objectDefinition);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getIsDecomposedBy(objectDefinition);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getIsDecomposedByDir(objectDefinition);
	}

	public List<Ref> getDecomposesRef(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getDecomposesRef(objectDefinition);
	}

	public List<IfcRelAggregates> getDecomposes(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getDecomposes(objectDefinition);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcObjectDefinition objectDefinition) {
		return objectDefinitionService.getDecomposesDir(objectDefinition);
	}

}
