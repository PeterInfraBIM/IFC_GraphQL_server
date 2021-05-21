package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.services.IfcRelSpaceBoundaryService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelSpaceBoundaryResolver implements GraphQLResolver<IfcRelSpaceBoundary> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcRelSpaceBoundaryService relSpaceBoundaryService;

	public IfcOwnerHistory getOwnerHistory(IfcRelSpaceBoundary relSpaceBoundary) {
		return rootService.getOwnerHistory(relSpaceBoundary);
	}

	public IfcSpace getRelatingSpace(IfcRelSpaceBoundary relSpaceBoundary) {
		return relSpaceBoundaryService.getRelatingSpace(relSpaceBoundary);
	}

	public IfcElement getRelatedBuildingElement(IfcRelSpaceBoundary relSpaceBoundary) {
		return relSpaceBoundaryService.getRelatedBuildingElement(relSpaceBoundary);
	}

}
