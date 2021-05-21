package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcSpace;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSpaceService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcSpaceResolver implements GraphQLResolver<IfcSpace> {

	@Autowired
	private IfcSpaceService spaceService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcSpace space) {
		return rootService.getOwnerHistory(space);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcSpace space) {
		return objectDefinitionService.getIsDecomposedBy(space);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcSpace space) {
		return objectDefinitionService.getIsDecomposedByDir(space);
	}

	public List<IfcRelAggregates> getDecomposes(IfcSpace space) {
		return objectDefinitionService.getDecomposes(space);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcSpace space) {
		return objectDefinitionService.getDecomposesDir(space);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcSpace space) {
		return objectService.getIsDefinedBy(space);
	}
	
	public List<IfcLocalPlacement> getObjectPlacements(IfcSpace space) {
		return productService.getObjectPlacements(space);
	}

	public List<IfcRelContainedInSpatialStructure> getContainsElements(IfcSpace space) {
		return spatialStructureElementService.getContainsElements(space);
	}

	public List<IfcProduct> getContainsElementsDir(IfcSpace space) {
		return spatialStructureElementService.getcontainsElementsDir(space);
	}

	public List<IfcRelSpaceBoundary> getBoundedBy(IfcSpace space) {
		return spaceService.getBoundedBy(space);
	}

	public List<IfcElement> getBoundedByDir(IfcSpace space) {
		return spaceService.getBoundedByDir(space);
	}
}
