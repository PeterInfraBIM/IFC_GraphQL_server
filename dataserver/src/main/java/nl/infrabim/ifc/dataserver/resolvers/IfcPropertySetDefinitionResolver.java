package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.services.IfcPropertyDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcPropertySetDefinitionResolver implements GraphQLResolver<IfcPropertySetDefinition> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcPropertyDefinitionService propertyDefinitionService;
	@Autowired
	private IfcPropertySetDefinitionService propertySetDefinitionService;

	public IfcOwnerHistory getOwnerHistory(IfcPropertySetDefinition propertySetDefinition) {
		return rootService.getOwnerHistory(propertySetDefinition);
	}

	public List<IfcRelAssociates> getHasAssociations(IfcPropertySetDefinition propertySetDefinition) {
		return propertyDefinitionService.getHasAssociations(propertySetDefinition);
	}

	public List<IfcTypeObject> getDefinesType(IfcPropertySetDefinition propertySetDefinition) {
		return propertySetDefinitionService.getDefinesType(propertySetDefinition);
	}

	public List<IfcRelDefinesByProperties> getPropertyDefinitionOf(IfcPropertySetDefinition propertySetDefinition) {
		return propertySetDefinitionService.getPropertyDefinitionOf(propertySetDefinition);
	}
}
