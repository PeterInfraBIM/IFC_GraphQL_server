package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcBeam;
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
public class IfcBeamResolver implements GraphQLResolver<IfcBeam> {

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

	public IfcOwnerHistory getOwnerHistory(IfcBeam beam) {
		return rootService.getOwnerHistory(beam);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcBeam beam) {
		return objectDefinitionService.getIsDecomposedBy(beam);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcBeam beam) {
		return objectDefinitionService.getIsDecomposedByDir(beam);
	}

	public List<IfcRelAggregates> getDecomposes(IfcBeam beam) {
		return objectDefinitionService.getDecomposes(beam);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcBeam beam) {
		return objectDefinitionService.getDecomposesDir(beam);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcBeam beam) {
		return productService.getObjectPlacements(beam);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcBeam beam) {
		return elementService.getHasAssociations(beam);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcBeam beam) {
		return elementService.getHasOpenings(beam);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcBeam beam) {
		return elementService.getFillsVoids(beam);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcBeam beam) {
		return elementService.getProvidesBoundaries(beam);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcBeam beam) {
		return objectService.getIsDefinedBy(beam);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcBeam beam) {
		return objectService.getIsDefinedByDir(beam);
	}

}
