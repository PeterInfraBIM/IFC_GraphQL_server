package nl.infrabim.ifc.dataserver.resolvers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import nl.infrabim.ifc.dataserver.models.IfcArbitraryClosedProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcExtrudedAreaSolid;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcPolyline;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcRepresentationItem;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.services.IfcBuildingService;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRelAggregatesService;
import nl.infrabim.ifc.dataserver.services.IfcRelContainedInSpatialStructureService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSiteService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;
import nl.infrabim.ifc.dataserver.services.IfcWallStandardCaseService;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcSiteService siteService;
	@Autowired
	private IfcBuildingService buildingService;
	@Autowired
	private IfcBuildingStoreyService buildingStoreyService;
	@Autowired
	private IfcRelAggregatesService relAggregatesService;
	@Autowired
	private IfcRelContainedInSpatialStructureService relContainedInSpatialStructureService;
	@Autowired
	private IfcWallStandardCaseService wallStandardCaseService;

	public List<IfcRoot> allRoots() throws IOException {
		return rootService.getAllRoots();
	}

	public List<IfcObjectDefinition> allObjectDefinitions() throws IOException {
		return objectDefinitionService.getAllObjectDefinitions();
	}

	public List<IfcProduct> allProducts() throws IOException {
		return productService.getAllProducts();
	}

	public List<IfcSpatialStructureElement> allSpatialStructureElements() throws IOException {
		return spatialStructureElementService.getAllSpatialStructureElements();
	}

	public List<IfcSite> allSites() throws IOException {
		return siteService.getAllSites();
	}

	public List<IfcBuilding> allBuildings() throws IOException {
		return buildingService.getAllBuildings();
	}

	public IfcBuilding oneBuilding(String globalId) throws IOException {
		return buildingService.getOneBuilding(globalId);
	}

	public List<IfcBuildingStorey> allBuildingStoreys() throws IOException {
		return buildingStoreyService.getAllBuildingStoreys();
	}

	public IfcBuildingStorey oneBuildingStorey(String globalId) throws IOException {
		return buildingStoreyService.getOneBuildingStorey(globalId);
	}

	public List<IfcRelAggregates> allRelAggregates() throws IOException {
		return relAggregatesService.getAllRelAggregates();
	}

	public List<IfcRelContainedInSpatialStructure> allRelContainedInSpatialStructures() throws IOException {
		return relContainedInSpatialStructureService.getAllRelContainedInSpatialStructures();
	}

	public List<IfcWallStandardCase> allWallStandardCases() throws IOException {
		return wallStandardCaseService.getAllWallStandardCases();
	}

	public IfcRepresentationItem getTestRepresentationItem() {
		return new IfcRepresentationItem();
	}

	public IfcPolyline getTestPolyline() {
		return new IfcPolyline();
	}

	public IfcExtrudedAreaSolid getTestExtrudedAreaSolid() {
		return new IfcExtrudedAreaSolid();
	}

	public IfcProfileDef getTestProfileDef() {
		return new IfcProfileDef();
	}
	
	public IfcArbitraryClosedProfileDef getTestArbitraryClosedProfileDef() {
		return new IfcArbitraryClosedProfileDef();
	}

}
