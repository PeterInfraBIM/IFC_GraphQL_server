package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProperty;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcPropertySetResolver implements GraphQLResolver<IfcPropertySet> {
	
	@Autowired
	private IfcPropertySetService propertySetService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcPropertySet propertySet) {
		return rootService.getOwnerHistory(propertySet);
	}

	public List<IfcProperty> getHasProperties(IfcPropertySet propertySet) {
		return propertySetService.getHasProperties(propertySet);
	}

}
