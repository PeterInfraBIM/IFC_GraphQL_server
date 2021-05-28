package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcDoorStyle;
import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcTypeObjectService;

@Component
public class IfcDoorStyleResolver implements GraphQLResolver<IfcDoorStyle> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcTypeObjectService typeObjectService;

	public IfcOwnerHistory getOwnerHistory(IfcDoorStyle doorStyle) {
		return rootService.getOwnerHistory(doorStyle);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcDoorStyle doorStyle) {
		return objectDefinitionService.getIsDecomposedBy(doorStyle);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcDoorStyle doorStyle) {
		return objectDefinitionService.getIsDecomposedByDir(doorStyle);
	}

	public List<IfcRelAggregates> getDecomposes(IfcDoorStyle doorStyle) {
		return objectDefinitionService.getDecomposes(doorStyle);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcDoorStyle doorStyle) {
		return objectDefinitionService.getDecomposesDir(doorStyle);
	}

	public List<IfcRelDefinesByType> getObjectTypeOf(IfcDoorStyle doorStyle) {
		return typeObjectService.getObjectTypeOf(doorStyle);
	}

	public List<IfcObject> getObjectTypeOfDir(IfcDoorStyle doorStyle) {
		return typeObjectService.getObjectTypeOfDir(doorStyle);
	}

	public List<IfcPropertySetDefinition> getHasPropertySets(IfcDoorStyle doorStyle) {
		return typeObjectService.getHasPropertySets(doorStyle);
	}

}
