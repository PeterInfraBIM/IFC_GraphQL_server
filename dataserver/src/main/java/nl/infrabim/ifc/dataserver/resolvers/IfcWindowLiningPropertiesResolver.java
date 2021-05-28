package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.models.IfcWindowLiningProperties;
import nl.infrabim.ifc.dataserver.services.IfcPropertyDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcWindowLiningPropertiesResolver implements GraphQLResolver<IfcWindowLiningProperties> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcPropertyDefinitionService propertyDefinitionService;
	@Autowired
	private IfcPropertySetDefinitionService propertySetDefinitionService;

	public IfcOwnerHistory getOwnerHistory(IfcWindowLiningProperties windowLiningProperties) {
		return rootService.getOwnerHistory(windowLiningProperties);
	}

	public List<IfcRelAssociates> getHasAssociations(IfcWindowLiningProperties windowLiningProperties) {
		return propertyDefinitionService.getHasAssociations(windowLiningProperties);
	}

	public List<IfcTypeObject> getDefinesType(IfcWindowLiningProperties windowLiningProperties) {
		return propertySetDefinitionService.getDefinesType(windowLiningProperties);
	}

	public List<IfcRelDefinesByProperties> getPropertyDefinitionOf(IfcWindowLiningProperties windowLiningProperties) {
		return propertySetDefinitionService.getPropertyDefinitionOf(windowLiningProperties);
	}
}
