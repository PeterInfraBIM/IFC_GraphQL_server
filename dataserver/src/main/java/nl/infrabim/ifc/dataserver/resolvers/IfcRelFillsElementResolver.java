package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.services.IfcRelFillsElementService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelFillsElementResolver implements GraphQLResolver<IfcRelFillsElement> {
	@Autowired
	private IfcRelFillsElementService relFillsElementService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelFillsElement relFillsElement) {
		return rootService.getOwnerHistory(relFillsElement);
	}

	public IfcOpeningElement getRelatingOpeningElement(IfcRelFillsElement relFillsElement) {
		return relFillsElementService.getRelatingOpeningElement(relFillsElement);
	}

	public IfcElement getRelatedBuildingElement(IfcRelFillsElement relFillsElement) {
		return relFillsElementService.getRelatedBuildingElement(relFillsElement);
	}
}
