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
import nl.infrabim.ifc.dataserver.models.IfcRoof;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRoofResolver implements GraphQLResolver<IfcRoof> {

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

	public IfcOwnerHistory getOwnerHistory(IfcRoof roof) {
		return rootService.getOwnerHistory(roof);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcRoof roof) {
		return objectDefinitionService.getIsDecomposedBy(roof);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcRoof roof) {
		return objectDefinitionService.getIsDecomposedByDir(roof);
	}

	public List<IfcRelAggregates> getDecomposes(IfcRoof roof) {
		return objectDefinitionService.getDecomposes(roof);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcRoof roof) {
		return objectDefinitionService.getDecomposesDir(roof);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcRoof roof) {
		return productService.getObjectPlacements(roof);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcRoof roof) {
		return elementService.getHasAssociations(roof);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcRoof roof) {
		return elementService.getHasOpenings(roof);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcRoof roof) {
		return elementService.getFillsVoids(roof);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcRoof roof) {
		return elementService.getProvidesBoundaries(roof);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcRoof roof) {
		return objectService.getIsDefinedBy(roof);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcRoof roof) {
		return objectService.getIsDefinedByDir(roof);
	}

}
