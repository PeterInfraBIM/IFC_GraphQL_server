package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcProperty;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;

@Component
public class IfcPropertySetResolver implements GraphQLResolver<IfcPropertySet> {
	
	@Autowired
	private IfcPropertySetService propertySetService;

	public List<IfcProperty> getHasProperties(IfcPropertySet propertySet) {
		return propertySetService.getHasProperties(propertySet);
	}

}
