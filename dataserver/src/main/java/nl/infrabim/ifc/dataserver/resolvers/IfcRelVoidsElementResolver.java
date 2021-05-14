package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.services.IfcOpeningElementService;
import nl.infrabim.ifc.dataserver.services.IfcRelVoidsElementService;

@Component
public class IfcRelVoidsElementResolver implements GraphQLResolver<IfcRelVoidsElement> {
	@Autowired
	private IfcRelVoidsElementService relVoidsElementService;

	public IfcOpeningElement getRelatedOpeningElement(IfcRelVoidsElement relVoidsElement) {
		return relVoidsElementService.getRelatedOpeningElement(relVoidsElement);
	}

	public IfcElement getRelatingBuildingElement(IfcRelVoidsElement relVoidsElement) {
		return relVoidsElementService.getRelatingBuildingElement(relVoidsElement);
	}
}
