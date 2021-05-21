package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcSpatialStructureElementResolver implements GraphQLResolver<IfcSpatialStructureElement> {

	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcSpatialStructureElement spatialStructureElement) {
		return rootService.getOwnerHistory(spatialStructureElement);
	}

	public List<Ref> getIsDecomposedByRef(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedByRef(spatialStructureElement);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedBy(spatialStructureElement);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedByDir(spatialStructureElement);
	}

	public List<Ref> getDecomposesRef(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposesRef(spatialStructureElement);
	}

	public List<IfcRelAggregates> getDecomposes(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposes(spatialStructureElement);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposesDir(spatialStructureElement);
	}

	public List<Ref> getcontainsElementsRef(IfcSpatialStructureElement spatialStructureElement) {
		return spatialStructureElementService.getcontainsElementsRef(spatialStructureElement);
	}
	
	public List<IfcRelContainedInSpatialStructure> getContainsElements(IfcSpatialStructureElement spatialStructureElement) {
		return spatialStructureElementService.getContainsElements(spatialStructureElement);
	}
	
	public List<IfcProduct> getContainsElementsDir(IfcSpatialStructureElement spatialStructureElement) {
		return spatialStructureElementService.getcontainsElementsDir(spatialStructureElement);
	}
	
	public List<IfcLocalPlacement> getObjectPlacements(IfcSpatialStructureElement spatialStructureElement) {
		return productService.getObjectPlacements(spatialStructureElement);
	}

}
