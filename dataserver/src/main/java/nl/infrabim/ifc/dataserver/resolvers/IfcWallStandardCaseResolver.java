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
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcWallStandardCaseResolver implements GraphQLResolver<IfcWallStandardCase> {

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

	public IfcOwnerHistory getOwnerHistory(IfcWallStandardCase wallStandardCase) {
		return rootService.getOwnerHistory(wallStandardCase);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getIsDecomposedBy(wallStandardCase);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getIsDecomposedByDir(wallStandardCase);
	}

	public List<IfcRelAggregates> getDecomposes(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getDecomposes(wallStandardCase);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcWallStandardCase wallStandardCase) {
		return objectDefinitionService.getDecomposesDir(wallStandardCase);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcWallStandardCase wallStandardCase) {
		return productService.getObjectPlacements(wallStandardCase);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcWallStandardCase wallStandardCase) {
		return elementService.getHasAssociations(wallStandardCase);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcWallStandardCase wallStandardCase) {
		return elementService.getHasOpenings(wallStandardCase);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcWallStandardCase wallStandardCase) {
		return elementService.getFillsVoids(wallStandardCase);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcWallStandardCase wallStandardCase) {
		return elementService.getProvidesBoundaries(wallStandardCase);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcWallStandardCase wallStandardCase) {
		return objectService.getIsDefinedBy(wallStandardCase);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcWallStandardCase wallStandardCase) {
		return objectService.getIsDefinedByDir(wallStandardCase);
	}

}
