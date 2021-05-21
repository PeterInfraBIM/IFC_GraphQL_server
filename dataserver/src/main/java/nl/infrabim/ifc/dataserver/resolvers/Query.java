package nl.infrabim.ifc.dataserver.resolvers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import nl.infrabim.ifc.dataserver.models.IfcArbitraryClosedProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcBooleanValue;
import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcDoor;
import nl.infrabim.ifc.dataserver.models.IfcExtrudedAreaSolid;
import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcPolyline;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcProject;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcPropertySingleValue;
import nl.infrabim.ifc.dataserver.models.IfcRealValue;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.IfcRepresentationItem;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.IfcStairFlight;
import nl.infrabim.ifc.dataserver.models.IfcValue;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.services.IfcBuildingService;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcDoorService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcOpeningElementService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcProjectService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;
import nl.infrabim.ifc.dataserver.services.IfcRelAggregatesService;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesMaterialService;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesService;
import nl.infrabim.ifc.dataserver.services.IfcRelContainedInSpatialStructureService;
import nl.infrabim.ifc.dataserver.services.IfcRelDefinesByPropertiesService;
import nl.infrabim.ifc.dataserver.services.IfcRelFillsElementService;
import nl.infrabim.ifc.dataserver.services.IfcRelSpaceBoundaryService;
import nl.infrabim.ifc.dataserver.services.IfcRelVoidsElementService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSiteService;
import nl.infrabim.ifc.dataserver.services.IfcSpaceService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;
import nl.infrabim.ifc.dataserver.services.IfcStairFlightService;
import nl.infrabim.ifc.dataserver.services.IfcWallStandardCaseService;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProjectService projectService;
	@Autowired
	private IfcSiteService siteService;
	@Autowired
	private IfcBuildingService buildingService;
	@Autowired
	private IfcBuildingStoreyService buildingStoreyService;
	@Autowired
	private IfcSpaceService spaceService;
	@Autowired
	private IfcRelAggregatesService relAggregatesService;
	@Autowired
	private IfcRelContainedInSpatialStructureService relContainedInSpatialStructureService;
	@Autowired
	private IfcRelAssociatesService relAssociatesService;
	@Autowired
	private IfcRelAssociatesMaterialService relAssociatesMaterialService;
	@Autowired
	private IfcRelDefinesByPropertiesService relDefinesByPropertiesService;
	@Autowired
	private IfcRelVoidsElementService relVoidsElementService;
	@Autowired
	private IfcRelFillsElementService relFillsElementService;
	@Autowired
	private IfcRelSpaceBoundaryService relSpaceBoundaryService;
	@Autowired
	private IfcWallStandardCaseService wallStandardCaseService;
	@Autowired
	private IfcDoorService doorService;
	@Autowired
	private IfcOpeningElementService openingElementService;
	@Autowired
	private IfcPropertySetService propertySetService;
	@Autowired
	private IfcStairFlightService stairFlightService;

	public List<IfcRoot> allRoots() throws IOException {
		return rootService.getAllRoots();
	}

	public List<IfcObjectDefinition> allObjectDefinitions() throws IOException {
		return objectDefinitionService.getAllObjectDefinitions();
	}

	public List<IfcObject> allObjects() throws IOException {
		return objectService.getAllObjects();
	}

	public List<IfcProduct> allProducts() throws IOException {
		return productService.getAllProducts();
	}

	public List<IfcSpatialStructureElement> allSpatialStructureElements() throws IOException {
		return spatialStructureElementService.getAllSpatialStructureElements();
	}

	public List<IfcProject> allProjects() throws IOException {
		return projectService.getAllProjects();
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

	public List<IfcSpace> allSpaces() throws IOException {
		return spaceService.getAllSpaces();
	}

	public IfcSpace oneSpace(String globalId) throws IOException {
		return spaceService.getOneSpace(globalId);
	}

	public List<IfcRelAggregates> allRelAggregates() throws IOException {
		return relAggregatesService.getAllRelAggregates();
	}

	public List<IfcRelContainedInSpatialStructure> allRelContainedInSpatialStructures() throws IOException {
		return relContainedInSpatialStructureService.getAllRelContainedInSpatialStructures();
	}

	public List<IfcRelAssociates> allRelAssociates() throws IOException {
		return relAssociatesService.getAllRelAssociates();
	}

	public List<IfcRelAssociatesMaterial> allRelAssociatesMaterials() throws IOException {
		return relAssociatesMaterialService.getAllRelAssociatesMaterials();
	}

	public List<IfcRelDefinesByProperties> allRelDefinesByProperties() throws IOException {
		return relDefinesByPropertiesService.getAllRelDefinesByProperties();
	}

	public List<IfcRelVoidsElement> allRelVoidsElements() throws IOException {
		return relVoidsElementService.getAllRelVoidsElements();
	}

	public List<IfcRelFillsElement> allRelFillsElements() throws IOException {
		return relFillsElementService.getAllRelFillsElements();
	}
	
	public List<IfcRelSpaceBoundary> allRelSpaceBoundaries() throws IOException {
		return relSpaceBoundaryService.getAllRelSpaceBoundaries();
	}
	
	public IfcRelSpaceBoundary oneRelSpaceBoundary(String globalId) throws IOException {
		return relSpaceBoundaryService.getOneRelSpaceBoundary(globalId);
	}

	public List<IfcWallStandardCase> allWallStandardCases() throws IOException {
		return wallStandardCaseService.getAllWallStandardCases();
	}

	public List<IfcDoor> allDoors() throws IOException {
		return doorService.getAllDoors();
	}

	public List<IfcOpeningElement> allOpeningElements() throws IOException {
		return openingElementService.getAllOpeningElements();
	}

	public List<IfcPropertySet> allPropertySets() throws IOException {
		return propertySetService.getAllPropertySets();
	}

	public List<IfcStairFlight> allStairFlights() throws IOException {
		return stairFlightService.getAllStairFlights();
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

	public IfcPropertySingleValue getTestPropertySingleValue() {
		return new IfcPropertySingleValue();
	}

	public IfcValue getTestValue() {
		return new IfcValue();
	}

	public IfcBooleanValue getTestBooleanValue() {
		return new IfcBooleanValue();
	}

	public IfcRealValue getTestRealValue() {
		return new IfcRealValue();
	}

}
