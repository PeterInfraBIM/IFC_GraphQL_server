package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcBuildingResolver implements GraphQLResolver<IfcBuilding> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcBuilding building) {
		return rootService.getOwnerHistory(building);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcBuilding building) {
		return objectDefinitionService.getIsDecomposedBy(building);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcBuilding building) {
		return objectDefinitionService.getIsDecomposedByDir(building);
	}

	public List<IfcRelAggregates> getDecomposes(IfcBuilding building) {
		return objectDefinitionService.getDecomposes(building);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcBuilding building) {
		return objectDefinitionService.getDecomposesDir(building);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcBuilding building) {
		return productService.getObjectPlacements(building);
	}
	
	public List<IfcRelContainedInSpatialStructure> getContainsElements(IfcBuilding building) {
		return spatialStructureElementService.getContainsElements(building);
	}
	
	public List<IfcProduct> getContainsElementsDir(IfcBuilding building) {
		return spatialStructureElementService.getcontainsElementsDir(building);
	}
}
