package nl.infrabim.ifc.dataserver.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelConnectsPathElements;
import nl.infrabim.ifc.dataserver.services.IfcRelConnectsPathElementsService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelConnectsPathElementsResolver implements GraphQLResolver<IfcRelConnectsPathElements> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcRelConnectsPathElementsService relConnectsPathElementsService;

	public IfcOwnerHistory getOwnerHistory(IfcRelConnectsPathElements relConnectsPathElements) {
		return rootService.getOwnerHistory(relConnectsPathElements);
	}
	
	public  IfcElement getRelatingElement(IfcRelConnectsPathElements relConnectsPathElements) {
		return relConnectsPathElementsService.getRelatingElement(relConnectsPathElements);
	}
	
	public  IfcElement getRelatedElement(IfcRelConnectsPathElements relConnectsPathElements) {
		return relConnectsPathElementsService.getRelatedElement(relConnectsPathElements);
	}

}
