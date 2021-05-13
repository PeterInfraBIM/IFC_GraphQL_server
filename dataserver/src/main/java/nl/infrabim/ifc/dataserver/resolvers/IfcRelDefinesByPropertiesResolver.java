package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;

@Component
public class IfcRelDefinesByPropertiesResolver implements GraphQLResolver<IfcRelDefinesByProperties> {
	@Autowired
	private IfcPropertySetService propertySetService;

	public IfcPropertySet getRelatingPropertyDefinition(IfcRelDefinesByProperties RelDefinesByProperties) {
		Ref relatingPropertyDefinitionRef = RelDefinesByProperties.getRelatingPropertyDefinitionRef();
		if (relatingPropertyDefinitionRef != null) {
			return propertySetService.getPropertySetDefinitionByGlobalId(relatingPropertyDefinitionRef.getRef());
		}
		return null;
	}
}
