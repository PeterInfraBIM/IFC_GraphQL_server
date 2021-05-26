package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcWindowLiningProperties;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcWindowLiningPropertiesResolver implements GraphQLResolver<IfcWindowLiningProperties> {
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcWindowLiningProperties windowLiningProperties) {
		return rootService.getOwnerHistory(windowLiningProperties);
	}

}
