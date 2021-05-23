package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRailing;
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
public class IfcRailingResolver implements GraphQLResolver<IfcRailing> {

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

	public IfcOwnerHistory getOwnerHistory(IfcRailing railing) {
		return rootService.getOwnerHistory(railing);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcRailing railing) {
		return objectDefinitionService.getIsDecomposedBy(railing);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcRailing railing) {
		return objectDefinitionService.getIsDecomposedByDir(railing);
	}

	public List<IfcRelAggregates> getDecomposes(IfcRailing railing) {
		return objectDefinitionService.getDecomposes(railing);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcRailing railing) {
		return objectDefinitionService.getDecomposesDir(railing);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcRailing railing) {
		return productService.getObjectPlacements(railing);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcRailing railing) {
		return elementService.getHasAssociations(railing);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcRailing railing) {
		return elementService.getHasOpenings(railing);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcRailing railing) {
		return elementService.getFillsVoids(railing);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcRailing railing) {
		return elementService.getProvidesBoundaries(railing);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcRailing railing) {
		return objectService.getIsDefinedBy(railing);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcRailing railing) {
		return objectService.getIsDefinedByDir(railing);
	}

}
