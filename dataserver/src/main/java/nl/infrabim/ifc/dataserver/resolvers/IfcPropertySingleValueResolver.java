package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcPropertySingleValue;
import nl.infrabim.ifc.dataserver.models.IfcValue;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;

@Component
public class IfcPropertySingleValueResolver implements GraphQLResolver<IfcPropertySingleValue> {
	
	@Autowired
	private IfcPropertySetService propertySetService;

	public IfcValue getNominalValue(IfcPropertySingleValue propertySingleValue) {
		return propertySetService.getNominalValue(propertySingleValue);
	}

}
