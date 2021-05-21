package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcBuildingStoreyResolver implements GraphQLResolver<IfcBuildingStorey> {

	@Autowired
	private IfcBuildingStoreyService buildingStoreyService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcBuildingStorey buildingStorey) {
		return rootService.getOwnerHistory(buildingStorey);
	}

	public List<Ref> getIsDecomposedByRef(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getIsDecomposedByRef(buildingStorey);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getIsDecomposedBy(buildingStorey);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getIsDecomposedByDir(buildingStorey);
	}

	public List<Ref> getDecomposesRef(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getDecomposesRef(buildingStorey);
	}

	public List<IfcRelAggregates> getDecomposes(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getDecomposes(buildingStorey);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcBuildingStorey buildingStorey) {
		return objectDefinitionService.getDecomposesDir(buildingStorey);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcBuildingStorey buildingStorey) {
		return productService.getObjectPlacements(buildingStorey);
	}

	public List<IfcRelContainedInSpatialStructure> getContainsElements(IfcBuildingStorey buildingStorey) {
		return spatialStructureElementService.getContainsElements(buildingStorey);
	}

	public List<IfcProduct> getContainsElementsDir(IfcBuildingStorey buildingStorey) {
		return spatialStructureElementService.getcontainsElementsDir(buildingStorey);
	}

	public Float getElevation(IfcBuildingStorey buildingStorey) {
		return buildingStoreyService.getElevation(buildingStorey);
	}
}
