package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcCovering;
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
public class IfcCoveringResolver implements GraphQLResolver<IfcCovering> {

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

	public IfcOwnerHistory getOwnerHistory(IfcCovering covering) {
		return rootService.getOwnerHistory(covering);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcCovering covering) {
		return objectDefinitionService.getIsDecomposedBy(covering);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcCovering covering) {
		return objectDefinitionService.getIsDecomposedByDir(covering);
	}

	public List<IfcRelAggregates> getDecomposes(IfcCovering covering) {
		return objectDefinitionService.getDecomposes(covering);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcCovering covering) {
		return objectDefinitionService.getDecomposesDir(covering);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcCovering covering) {
		return productService.getObjectPlacements(covering);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcCovering covering) {
		return elementService.getHasAssociations(covering);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcCovering covering) {
		return elementService.getHasOpenings(covering);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcCovering covering) {
		return elementService.getFillsVoids(covering);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcCovering covering) {
		return elementService.getProvidesBoundaries(covering);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcCovering covering) {
		return objectService.getIsDefinedBy(covering);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcCovering covering) {
		return objectService.getIsDefinedByDir(covering);
	}

}
