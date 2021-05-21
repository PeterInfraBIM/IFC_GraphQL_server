package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.IfcStairFlight;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcStairFlightResolver implements GraphQLResolver<IfcStairFlight> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcObjectService objectService;

	public IfcOwnerHistory getOwnerHistory(IfcStairFlight stairFlight) {
		return rootService.getOwnerHistory(stairFlight);
	}
	
	public List<IfcRelAggregates> getIsDecomposedBy(IfcStairFlight stairFlight) {
		return objectDefinitionService.getIsDecomposedBy(stairFlight);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcStairFlight stairFlight) {
		return objectDefinitionService.getIsDecomposedByDir(stairFlight);
	}

	public List<IfcRelAggregates> getDecomposes(IfcStairFlight stairFlight) {
		return objectDefinitionService.getDecomposes(stairFlight);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcStairFlight stairFlight) {
		return objectDefinitionService.getDecomposesDir(stairFlight);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcStairFlight stairFlight) {
		return productService.getObjectPlacements(stairFlight);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcStairFlight stairFlight) {
		return elementService.getHasAssociations(stairFlight);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcStairFlight stairFlight) {
		return elementService.getHasOpenings(stairFlight);
	}
	
	public List<IfcRelFillsElement> getFillsVoids(IfcStairFlight stairFlight){
		return elementService.getFillsVoids(stairFlight);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcStairFlight stairFlight) {
		return objectService.getIsDefinedBy(stairFlight);
	}

}
