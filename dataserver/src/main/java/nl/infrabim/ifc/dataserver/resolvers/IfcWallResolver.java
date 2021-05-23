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
import nl.infrabim.ifc.dataserver.models.IfcWall;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcWallResolver implements GraphQLResolver<IfcWall> {

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

	public IfcOwnerHistory getOwnerHistory(IfcWall wall) {
		return rootService.getOwnerHistory(wall);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcWall wall) {
		return objectDefinitionService.getIsDecomposedBy(wall);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcWall wall) {
		return objectDefinitionService.getIsDecomposedByDir(wall);
	}

	public List<IfcRelAggregates> getDecomposes(IfcWall wall) {
		return objectDefinitionService.getDecomposes(wall);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcWall wall) {
		return objectDefinitionService.getDecomposesDir(wall);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcWall wall) {
		return productService.getObjectPlacements(wall);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcWall wall) {
		return elementService.getHasAssociations(wall);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcWall wall) {
		return elementService.getHasOpenings(wall);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcWall wall) {
		return elementService.getFillsVoids(wall);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcWall wall) {
		return elementService.getProvidesBoundaries(wall);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcWall wall) {
		return objectService.getIsDefinedBy(wall);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcWall wall) {
		return objectService.getIsDefinedByDir(wall);
	}

}
