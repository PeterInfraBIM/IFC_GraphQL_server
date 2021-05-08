package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcBuildingResolver implements GraphQLResolver<IfcBuilding> {

	@Autowired
	private IfcBuildingStoreyService buildingStoreyService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;

	public List<Ref> getIsDecomposedByRef(IfcBuilding building) {
		return objectDefinitionService.getIsDecomposedByRef(building);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcBuilding building) {
		return objectDefinitionService.getIsDecomposedBy(building);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcBuilding building) {
		return objectDefinitionService.getIsDecomposedByDir(building);
	}

	public List<Ref> getDecomposesRef(IfcBuilding building) {
		return objectDefinitionService.getDecomposesRef(building);
	}

	public List<IfcRelAggregates> getDecomposes(IfcBuilding building) {
		return objectDefinitionService.getDecomposes(building);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcBuilding building) {
		return objectDefinitionService.getDecomposesDir(building);
	}

	public IfcElementCompositionEnum getCompositionType(IfcBuilding building) {
		return spatialStructureElementService.getCompositionType(building);
	}

	public IfcLocalPlacement getObjectPlacement(IfcBuilding building) {
		return productService.getObjectPlacement(building);
	}
}
