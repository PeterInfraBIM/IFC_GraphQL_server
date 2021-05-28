package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.models.IfcWindowStyle;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcTypeObjectService;

@Component
public class IfcWindowStyleResolver implements GraphQLResolver<IfcWindowStyle> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcTypeObjectService typeObjectService;

	public IfcOwnerHistory getOwnerHistory(IfcWindowStyle windowStyle) {
		return rootService.getOwnerHistory(windowStyle);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcWindowStyle windowStyle) {
		return objectDefinitionService.getIsDecomposedBy(windowStyle);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcWindowStyle windowStyle) {
		return objectDefinitionService.getIsDecomposedByDir(windowStyle);
	}

	public List<IfcRelAggregates> getDecomposes(IfcWindowStyle windowStyle) {
		return objectDefinitionService.getDecomposes(windowStyle);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcWindowStyle windowStyle) {
		return objectDefinitionService.getDecomposesDir(windowStyle);
	}

	public List<IfcRelDefinesByType> getObjectTypeOf(IfcWindowStyle windowStyle) {
		return typeObjectService.getObjectTypeOf(windowStyle);
	}

	public List<IfcObject> getObjectTypeOfDir(IfcWindowStyle windowStyle) {
		return typeObjectService.getObjectTypeOfDir(windowStyle);
	}

	public List<IfcPropertySetDefinition> getHasPropertySets(IfcWindowStyle windowStyle) {
		return typeObjectService.getHasPropertySets(windowStyle);
	}
}
