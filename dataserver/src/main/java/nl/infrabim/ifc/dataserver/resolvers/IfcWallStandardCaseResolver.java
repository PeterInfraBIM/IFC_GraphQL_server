package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcWallStandardCaseResolver implements GraphQLResolver<IfcWallStandardCase> {

	@Autowired
	private IfcBuildingStoreyService buildingStoreyService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;

	public List<Ref> getIsDecomposedByRef(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getIsDecomposedByRef(wallStandardCase);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getIsDecomposedBy(wallStandardCase);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getIsDecomposedByDir(wallStandardCase);
	}

	public List<Ref> getDecomposesRef(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getDecomposesRef(wallStandardCase);
	}

	public List<IfcRelAggregates> getDecomposes(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getDecomposes(wallStandardCase);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getDecomposesDir(wallStandardCase);
	}

	public IfcLocalPlacement getObjectPlacement(IfcWallStandardCase wallStandardCase) {
		return productService.getObjectPlacement(wallStandardCase);
	}

}
