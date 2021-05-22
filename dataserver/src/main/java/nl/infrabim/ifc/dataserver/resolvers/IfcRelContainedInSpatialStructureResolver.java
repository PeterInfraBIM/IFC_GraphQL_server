package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelContainedInSpatialStructureResolver implements GraphQLResolver<IfcRelContainedInSpatialStructure> {
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelContainedInSpatialStructure relContainedInSpatialStructure) {
		return rootService.getOwnerHistory(relContainedInSpatialStructure);
	}

}
