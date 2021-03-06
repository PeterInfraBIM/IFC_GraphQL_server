package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcDoorLiningProperties;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.services.IfcPropertyDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcDoorLiningPropertiesResolver implements GraphQLResolver<IfcDoorLiningProperties> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcPropertyDefinitionService propertyDefinitionService;
	@Autowired
	private IfcPropertySetDefinitionService propertySetDefinitionService;

	public IfcOwnerHistory getOwnerHistory(IfcDoorLiningProperties doorLiningProperties) {
		return rootService.getOwnerHistory(doorLiningProperties);
	}

	public List<IfcRelAssociates> getHasAssociations(IfcDoorLiningProperties doorLiningProperties) {
		return propertyDefinitionService.getHasAssociations(doorLiningProperties);
	}

	public List<IfcTypeObject> getDefinesType(IfcDoorLiningProperties doorLiningProperties) {
		return propertySetDefinitionService.getDefinesType(doorLiningProperties);
	}

	public List<IfcRelDefinesByProperties> getPropertyDefinitionOf(IfcDoorLiningProperties doorLiningProperties) {
		return propertySetDefinitionService.getPropertyDefinitionOf(doorLiningProperties);
	}
}
