package nl.infrabim.ifc.dataserver.resolvers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import nl.infrabim.ifc.dataserver.models.IfcArbitraryClosedProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcBeam;
import nl.infrabim.ifc.dataserver.models.IfcBooleanValue;
import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcCovering;
import nl.infrabim.ifc.dataserver.models.IfcDoor;
import nl.infrabim.ifc.dataserver.models.IfcDoorLiningProperties;
import nl.infrabim.ifc.dataserver.models.IfcDoorStyle;
import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcExtrudedAreaSolid;
import nl.infrabim.ifc.dataserver.models.IfcFooting;
import nl.infrabim.ifc.dataserver.models.IfcFurnishingElement;
import nl.infrabim.ifc.dataserver.models.IfcIntegerValue;
import nl.infrabim.ifc.dataserver.models.IfcLabel;
import nl.infrabim.ifc.dataserver.models.IfcMember;
import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcPolyline;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcProfileDef;
import nl.infrabim.ifc.dataserver.models.IfcProject;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcPropertySingleValue;
import nl.infrabim.ifc.dataserver.models.IfcRailing;
import nl.infrabim.ifc.dataserver.models.IfcRealValue;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelConnectsPathElements;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.IfcRepresentationItem;
import nl.infrabim.ifc.dataserver.models.IfcRoof;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.models.IfcSlab;
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.IfcStair;
import nl.infrabim.ifc.dataserver.models.IfcStairFlight;
import nl.infrabim.ifc.dataserver.models.IfcValue;
import nl.infrabim.ifc.dataserver.models.IfcWall;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.models.IfcWindow;
import nl.infrabim.ifc.dataserver.models.IfcWindowLiningProperties;
import nl.infrabim.ifc.dataserver.models.IfcWindowStyle;
import nl.infrabim.ifc.dataserver.services.IfcBeamService;
import nl.infrabim.ifc.dataserver.services.IfcBuildingService;
import nl.infrabim.ifc.dataserver.services.IfcBuildingStoreyService;
import nl.infrabim.ifc.dataserver.services.IfcCoveringService;
import nl.infrabim.ifc.dataserver.services.IfcDoorLiningPropertiesService;
import nl.infrabim.ifc.dataserver.services.IfcDoorService;
import nl.infrabim.ifc.dataserver.services.IfcDoorStyleService;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcFootingService;
import nl.infrabim.ifc.dataserver.services.IfcFurnishingElementService;
import nl.infrabim.ifc.dataserver.services.IfcMemberService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcOpeningElementService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcProjectService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;
import nl.infrabim.ifc.dataserver.services.IfcRailingService;
import nl.infrabim.ifc.dataserver.services.IfcRelAggregatesService;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesMaterialService;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesService;
import nl.infrabim.ifc.dataserver.services.IfcRelConnectsPathElementsService;
import nl.infrabim.ifc.dataserver.services.IfcRelContainedInSpatialStructureService;
import nl.infrabim.ifc.dataserver.services.IfcRelDefinesByPropertiesService;
import nl.infrabim.ifc.dataserver.services.IfcRelDefinesByTypeService;
import nl.infrabim.ifc.dataserver.services.IfcRelFillsElementService;
import nl.infrabim.ifc.dataserver.services.IfcRelSpaceBoundaryService;
import nl.infrabim.ifc.dataserver.services.IfcRelVoidsElementService;
import nl.infrabim.ifc.dataserver.services.IfcRoofService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSiteService;
import nl.infrabim.ifc.dataserver.services.IfcSlabService;
import nl.infrabim.ifc.dataserver.services.IfcSpaceService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;
import nl.infrabim.ifc.dataserver.services.IfcStairFlightService;
import nl.infrabim.ifc.dataserver.services.IfcStairService;
import nl.infrabim.ifc.dataserver.services.IfcWallService;
import nl.infrabim.ifc.dataserver.services.IfcWallStandardCaseService;
import nl.infrabim.ifc.dataserver.services.IfcWindowLiningPropertiesService;
import nl.infrabim.ifc.dataserver.services.IfcWindowService;
import nl.infrabim.ifc.dataserver.services.IfcWindowStyleService;

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
	private IfcElementService elementService;
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
	private IfcRelDefinesByTypeService relDefinesByTypeService;
	@Autowired
	private IfcRelVoidsElementService relVoidsElementService;
	@Autowired
	private IfcRelFillsElementService relFillsElementService;
	@Autowired
	private IfcRelSpaceBoundaryService relSpaceBoundaryService;
	@Autowired
	private IfcRelConnectsPathElementsService relConnectsPathElementsService;
	@Autowired
	private IfcWallService wallService;
	@Autowired
	private IfcWallStandardCaseService wallStandardCaseService;
	@Autowired
	private IfcDoorService doorService;
	@Autowired
	private IfcDoorLiningPropertiesService doorLiningPropertiesService;
	@Autowired
	private IfcDoorStyleService doorStyleService;
	@Autowired
	private IfcWindowService windowService;
	@Autowired
	private IfcWindowLiningPropertiesService windowLiningPropertiesService;
	@Autowired
	private IfcWindowStyleService windowStyleService;
	@Autowired
	private IfcOpeningElementService openingElementService;
	@Autowired
	private IfcPropertySetService propertySetService;
	@Autowired
	private IfcBeamService beamService;
	@Autowired
	private IfcCoveringService coveringService;
	@Autowired
	private IfcFootingService footingService;
	@Autowired
	private IfcFurnishingElementService furnishingElementService;
	@Autowired
	private IfcMemberService memberService;
	@Autowired
	private IfcSlabService slabService;
	@Autowired
	private IfcRailingService railingService;
	@Autowired
	private IfcRoofService roofService;
	@Autowired
	private IfcStairService stairService;
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

	public List<IfcElement> allElements() throws IOException {
		return elementService.getAllElements();
	}

	public List<IfcSpatialStructureElement> allSpatialStructureElements() throws IOException {
		return spatialStructureElementService.getAllSpatialStructureElements();
	}

	public List<IfcProject> allProjects() throws IOException {
		return projectService.getAllProjects();
	}

	public IfcProject oneProject(String globalId) throws IOException {
		return projectService.getOneProject(globalId);
	}

	public List<IfcSite> allSites() throws IOException {
		return siteService.getAllSites();
	}

	public IfcSite oneSite(String globalId) throws IOException {
		return siteService.getOneSite(globalId);
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

	public IfcRelAggregates oneRelAggregates(String globalId) throws IOException {
		return relAggregatesService.getOneRelAggregates(globalId);
	}

	public List<IfcRelContainedInSpatialStructure> allRelContainedInSpatialStructures() throws IOException {
		return relContainedInSpatialStructureService.getAllRelContainedInSpatialStructures();
	}

	public IfcRelContainedInSpatialStructure oneRelContainedInSpatialStructure(String globalId) throws IOException {
		return relContainedInSpatialStructureService.getOneRelContainedInSpatialStructure(globalId);
	}

	public List<IfcRelAssociates> allRelAssociates() throws IOException {
		return relAssociatesService.getAllRelAssociates();
	}

	public IfcRelAssociates oneRelAssociates(String globalId) throws IOException {
		return relAssociatesService.getOneRelAssociates(globalId);
	}

	public List<IfcRelAssociatesMaterial> allRelAssociatesMaterials() throws IOException {
		return relAssociatesMaterialService.getAllRelAssociatesMaterials();
	}

	public IfcRelAssociatesMaterial oneRelAssociatesMaterial(String globalId) throws IOException {
		return relAssociatesMaterialService.getOneRelAssociatesMaterial(globalId);
	}

	public List<IfcRelDefinesByProperties> allRelDefinesByProperties() throws IOException {
		return relDefinesByPropertiesService.getAllRelDefinesByProperties();
	}

	public IfcRelDefinesByProperties oneRelDefinesByProperties(String globalId) throws IOException {
		return relDefinesByPropertiesService.getOneRelDefinesByProperties(globalId);
	}

	public List<IfcRelDefinesByType> allRelDefinesByTypes() throws IOException {
		return relDefinesByTypeService.getAllRelDefinesByTypes();
	}

	public IfcRelDefinesByType oneRelDefinesByType(String globalId) throws IOException {
		return relDefinesByTypeService.getOneRelDefinesByType(globalId);
	}

	public List<IfcRelVoidsElement> allRelVoidsElements() throws IOException {
		return relVoidsElementService.getAllRelVoidsElements();
	}

	public IfcRelVoidsElement oneRelVoidsElement(String globalId) throws IOException {
		return relVoidsElementService.getOneRelVoidsElement(globalId);
	}

	public List<IfcRelFillsElement> allRelFillsElements() throws IOException {
		return relFillsElementService.getAllRelFillsElements();
	}

	public IfcRelFillsElement oneRelFillsElement(String globalId) throws IOException {
		return relFillsElementService.getOneRelFillsElement(globalId);
	}

	public List<IfcRelSpaceBoundary> allRelSpaceBoundaries() throws IOException {
		return relSpaceBoundaryService.getAllRelSpaceBoundaries();
	}

	public IfcRelSpaceBoundary oneRelSpaceBoundary(String globalId) throws IOException {
		return relSpaceBoundaryService.getOneRelSpaceBoundary(globalId);
	}

	public List<IfcRelConnectsPathElements> allRelConnectsPathElements() throws IOException {
		return relConnectsPathElementsService.getAllRelConnectsPathElements();
	}

	public IfcRelConnectsPathElements oneRelConnectsPathElements(String globalId) throws IOException {
		return relConnectsPathElementsService.getOneRelConnectsPathElements(globalId);
	}

	public List<IfcWall> allWalls() throws IOException {
		return wallService.getAllWalls();
	}

	public List<IfcWallStandardCase> allWallStandardCases() throws IOException {
		return wallStandardCaseService.getAllWallStandardCases();
	}

	public IfcWallStandardCase oneWallStandardCase(String globalId) throws IOException {
		return wallStandardCaseService.getOneWallStandardCase(globalId);
	}

	public List<IfcDoor> allDoors() throws IOException {
		return doorService.getAllDoors();
	}

	public IfcDoor oneDoor(String globalId) throws IOException {
		return doorService.getOneDoor(globalId);
	}

	public List<IfcDoorLiningProperties> allDoorLiningProperties() throws IOException {
		return doorLiningPropertiesService.getAllDoorLiningProperties();
	}

	public IfcDoorLiningProperties oneDoorLiningProperties(String globalId) throws IOException {
		return doorLiningPropertiesService.getOneDoorLiningProperties(globalId);
	}

	public List<IfcDoorStyle> allDoorStyles() throws IOException {
		return doorStyleService.getAllDoorStyles();
	}

	public IfcDoorStyle oneDoorStyle(String globalId) throws IOException {
		return doorStyleService.getOneDoorStyle(globalId);
	}

	public List<IfcWindow> allWindows() throws IOException {
		return windowService.getAllWindows();
	}

	public IfcWindow oneWindow(String globalId) throws IOException {
		return windowService.getOneWindow(globalId);
	}

	public List<IfcWindowLiningProperties> allWindowLiningProperties() throws IOException {
		return windowLiningPropertiesService.getAllWindowLiningProperties();
	}

	public IfcWindowLiningProperties oneWindowLiningProperties(String globalId) throws IOException {
		return windowLiningPropertiesService.getOneWindowLiningProperties(globalId);
	}

	public List<IfcWindowStyle> allWindowStyles() throws IOException {
		return windowStyleService.getAllWindowStyles();
	}

	public IfcWindowStyle oneWindowStyle(String globalId) throws IOException {
		return windowStyleService.getOneWindowStyle(globalId);
	}

	public List<IfcOpeningElement> allOpeningElements() throws IOException {
		return openingElementService.getAllOpeningElements();
	}

	public IfcOpeningElement oneOpeningElement(String globalId) throws IOException {
		return openingElementService.getOneOpeningElement(globalId);
	}

	public List<IfcPropertySet> allPropertySets() throws IOException {
		return propertySetService.getAllPropertySets();
	}

	public IfcPropertySet onePropertySet(String globalId) throws IOException {
		return propertySetService.getOnePropertySet(globalId);
	}

	public List<IfcBeam> allBeams() throws IOException {
		return beamService.getAllBeams();
	}

	public IfcBeam oneBeam(String globalId) throws IOException {
		return beamService.getOneBeam(globalId);
	}

	public List<IfcCovering> allCoverings() throws IOException {
		return coveringService.getAllCoverings();
	}

	public IfcCovering oneCovering(String globalId) throws IOException {
		return coveringService.getOneCovering(globalId);
	}

	public List<IfcFooting> allFootings() throws IOException {
		return footingService.getAllFootings();
	}

	public IfcFooting oneFooting(String globalId) throws IOException {
		return footingService.getOneFooting(globalId);
	}

	public List<IfcFurnishingElement> allFurnishingElements() throws IOException {
		return furnishingElementService.getAllFurnishingElements();
	}

	public IfcFurnishingElement oneFurnishingElement(String globalId) throws IOException {
		return furnishingElementService.getOneFurnishingElement(globalId);
	}

	public List<IfcMember> allMembers() throws IOException {
		return memberService.getAllMembers();
	}

	public IfcMember oneMember(String globalId) throws IOException {
		return memberService.getOneMember(globalId);
	}

	public List<IfcSlab> allSlabs() throws IOException {
		return slabService.getAllSlabs();
	}

	public IfcSlab oneSlab(String globalId) throws IOException {
		return slabService.getOneSlab(globalId);
	}

	public List<IfcRailing> allRailings() throws IOException {
		return railingService.getAllRailings();
	}

	public IfcRailing oneRailing(String globalId) throws IOException {
		return railingService.getOneRailing(globalId);
	}

	public List<IfcRoof> allRoofs() throws IOException {
		return roofService.getAllRoofs();
	}

	public IfcRoof oneRoof(String globalId) throws IOException {
		return roofService.getOneRoof(globalId);
	}

	public List<IfcStair> allStairs() throws IOException {
		return stairService.getAllStairs();
	}

	public IfcStair oneStair(String globalId) throws IOException {
		return stairService.getOneStair(globalId);
	}

	public List<IfcStairFlight> allStairFlights() throws IOException {
		return stairFlightService.getAllStairFlights();
	}

	public IfcStairFlight oneStairFlight(String globalId) throws IOException {
		return stairFlightService.getOneStairFlight(globalId);
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

	public IfcIntegerValue getTestIntegerValue() {
		return new IfcIntegerValue();
	}

	public IfcLabel getTestLabel() {
		return new IfcLabel();
	}

	public IfcRealValue getTestRealValue() {
		return new IfcRealValue();
	}

}
