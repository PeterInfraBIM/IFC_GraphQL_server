package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcFeatureElementSubtractionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcOpeningElementResolver implements GraphQLResolver<IfcOpeningElement> {

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
	@Autowired
	private IfcFeatureElementSubtractionService featureElementSubtractionService;

	public IfcOwnerHistory getOwnerHistory(IfcOpeningElement openingElement) {
		return rootService.getOwnerHistory(openingElement);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcOpeningElement openingElement) {
		return objectDefinitionService.getIsDecomposedBy(openingElement);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcOpeningElement openingElement) {
		return objectDefinitionService.getIsDecomposedByDir(openingElement);
	}

	public List<IfcRelAggregates> getDecomposes(IfcOpeningElement openingElement) {
		return objectDefinitionService.getDecomposes(openingElement);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcOpeningElement openingElement) {
		return objectDefinitionService.getDecomposesDir(openingElement);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcOpeningElement openingElement) {
		return elementService.getHasAssociations(openingElement);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcOpeningElement openingElement) {
		return elementService.getHasOpenings(openingElement);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcOpeningElement openingElement) {
		return elementService.getFillsVoids(openingElement);
	}

	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcOpeningElement openingElement) {
		return elementService.getProvidesBoundaries(openingElement);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcOpeningElement openingElement) {
		return objectService.getIsDefinedBy(openingElement);
	}

	public List<IfcPropertySet> getIsDefinedByDir(IfcOpeningElement openingElement) {
		return objectService.getIsDefinedByDir(openingElement);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcOpeningElement openingElement) {
		return productService.getObjectPlacements(openingElement);
	}

	public List<IfcRelVoidsElement> getVoidsElements(IfcOpeningElement openingElement) {
		return featureElementSubtractionService.getVoidsElements(openingElement);
	}

}
