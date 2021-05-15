package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRootResolver implements GraphQLResolver<IfcRoot> {
	
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRoot root) {
		return rootService.getOwnerHistory(root);
	}

}
