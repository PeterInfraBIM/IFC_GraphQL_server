package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcFooting;
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
public class IfcFootingResolver implements GraphQLResolver<IfcFooting> {

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

	public IfcOwnerHistory getOwnerHistory(IfcFooting footing) {
		return rootService.getOwnerHistory(footing);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcFooting footing) {
		return objectDefinitionService.getIsDecomposedBy(footing);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcFooting footing) {
		return objectDefinitionService.getIsDecomposedByDir(footing);
	}

	public List<IfcRelAggregates> getDecomposes(IfcFooting footing) {
		return objectDefinitionService.getDecomposes(footing);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcFooting footing) {
		return objectDefinitionService.getDecomposesDir(footing);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcFooting footing) {
		return productService.getObjectPlacements(footing);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcFooting footing) {
		return elementService.getHasAssociations(footing);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcFooting footing) {
		return elementService.getHasOpenings(footing);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcFooting footing) {
		return elementService.getFillsVoids(footing);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcFooting footing) {
		return elementService.getProvidesBoundaries(footing);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcFooting footing) {
		return objectService.getIsDefinedBy(footing);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcFooting footing) {
		return objectService.getIsDefinedByDir(footing);
	}

}
