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
import nl.infrabim.ifc.dataserver.models.IfcStair;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcStairResolver implements GraphQLResolver<IfcStair> {

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

	public IfcOwnerHistory getOwnerHistory(IfcStair stair) {
		return rootService.getOwnerHistory(stair);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcStair stair) {
		return objectDefinitionService.getIsDecomposedBy(stair);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcStair stair) {
		return objectDefinitionService.getIsDecomposedByDir(stair);
	}

	public List<IfcRelAggregates> getDecomposes(IfcStair stair) {
		return objectDefinitionService.getDecomposes(stair);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcStair stair) {
		return objectDefinitionService.getDecomposesDir(stair);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcStair stair) {
		return productService.getObjectPlacements(stair);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcStair stair) {
		return elementService.getHasAssociations(stair);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcStair stair) {
		return elementService.getHasOpenings(stair);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcStair stair) {
		return elementService.getFillsVoids(stair);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcStair stair) {
		return elementService.getProvidesBoundaries(stair);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcStair stair) {
		return objectService.getIsDefinedBy(stair);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcStair stair) {
		return objectService.getIsDefinedByDir(stair);
	}

}
