package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcFurnishingElement;
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
public class IfcFurnishingElementResolver implements GraphQLResolver<IfcFurnishingElement> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcFurnishingElement furnishingElement) {
		return rootService.getOwnerHistory(furnishingElement);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcFurnishingElement furnishingElement) {
		return objectDefinitionService.getIsDecomposedBy(furnishingElement);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcFurnishingElement furnishingElement) {
		return objectDefinitionService.getIsDecomposedByDir(furnishingElement);
	}

	public List<IfcRelAggregates> getDecomposes(IfcFurnishingElement furnishingElement) {
		return objectDefinitionService.getDecomposes(furnishingElement);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcFurnishingElement furnishingElement) {
		return objectDefinitionService.getDecomposesDir(furnishingElement);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcFurnishingElement furnishingElement) {
		return productService.getObjectPlacements(furnishingElement);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcFurnishingElement furnishingElement) {
		return elementService.getHasAssociations(furnishingElement);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcFurnishingElement furnishingElement) {
		return elementService.getHasOpenings(furnishingElement);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcFurnishingElement furnishingElement) {
		return elementService.getFillsVoids(furnishingElement);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcFurnishingElement furnishingElement) {
		return elementService.getProvidesBoundaries(furnishingElement);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcFurnishingElement furnishingElement) {
		return objectService.getIsDefinedBy(furnishingElement);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcFurnishingElement furnishingElement) {
		return objectService.getIsDefinedByDir(furnishingElement);
	}

}
