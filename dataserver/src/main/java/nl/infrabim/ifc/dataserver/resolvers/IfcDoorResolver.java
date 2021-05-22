package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcDoor;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcDoorResolver implements GraphQLResolver<IfcDoor> {
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

	public IfcOwnerHistory getOwnerHistory(IfcDoor door) {
		return rootService.getOwnerHistory(door);
	}
	
	public List<IfcRelAggregates> getIsDecomposedBy(IfcDoor door) {
		return objectDefinitionService.getIsDecomposedBy(door);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcDoor door) {
		return objectDefinitionService.getIsDecomposedByDir(door);
	}

	public List<IfcRelAggregates> getDecomposes(IfcDoor door) {
		return objectDefinitionService.getDecomposes(door);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcDoor door) {
		return objectDefinitionService.getDecomposesDir(door);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcDoor door) {
		return productService.getObjectPlacements(door);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcDoor door) {
		return elementService.getHasAssociations(door);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcDoor door) {
		return elementService.getHasOpenings(door);
	}
	
	public List<IfcRelFillsElement> getFillsVoids(IfcDoor door){
		return elementService.getFillsVoids(door);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcDoor door) {
		return elementService.getProvidesBoundaries(door);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcDoor door) {
		return objectService.getIsDefinedBy(door);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcDoor door) {
		return objectService.getIsDefinedByDir(door);
	}

}
