package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

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
import nl.infrabim.ifc.dataserver.models.IfcSlab;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcSlabResolver implements GraphQLResolver<IfcSlab> {
	@Autowired
	private IfcRootService rootService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcObjectService objectService;

	public IfcOwnerHistory getOwnerHistory(IfcSlab slab) {
		return rootService.getOwnerHistory(slab);
	}
	
	public List<IfcRelAggregates> getIsDecomposedBy(IfcSlab slab) {
		return objectDefinitionService.getIsDecomposedBy(slab);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcSlab slab) {
		return objectDefinitionService.getIsDecomposedByDir(slab);
	}

	public List<IfcRelAggregates> getDecomposes(IfcSlab slab) {
		return objectDefinitionService.getDecomposes(slab);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcSlab slab) {
		return objectDefinitionService.getDecomposesDir(slab);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcSlab slab) {
		return productService.getObjectPlacements(slab);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcSlab slab) {
		return elementService.getHasAssociations(slab);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcSlab slab) {
		return elementService.getHasOpenings(slab);
	}
	
	public List<IfcRelFillsElement> getFillsVoids(IfcSlab slab){
		return elementService.getFillsVoids(slab);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcSlab slab) {
		return elementService.getProvidesBoundaries(slab);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcSlab slab) {
		return objectService.getIsDefinedBy(slab);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcSlab slab) {
		return objectService.getIsDefinedByDir(slab);
	}

}
