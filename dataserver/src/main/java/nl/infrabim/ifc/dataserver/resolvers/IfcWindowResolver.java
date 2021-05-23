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
import nl.infrabim.ifc.dataserver.models.IfcWindow;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcWindowResolver implements GraphQLResolver<IfcWindow> {
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

	public IfcOwnerHistory getOwnerHistory(IfcWindow window) {
		return rootService.getOwnerHistory(window);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcWindow window) {
		return objectDefinitionService.getIsDecomposedBy(window);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcWindow window) {
		return objectDefinitionService.getIsDecomposedByDir(window);
	}

	public List<IfcRelAggregates> getDecomposes(IfcWindow window) {
		return objectDefinitionService.getDecomposes(window);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcWindow window) {
		return objectDefinitionService.getDecomposesDir(window);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcWindow window) {
		return productService.getObjectPlacements(window);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcWindow window) {
		return elementService.getHasAssociations(window);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcWindow window) {
		return elementService.getHasOpenings(window);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcWindow window) {
		return elementService.getFillsVoids(window);
	}

	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcWindow window) {
		return elementService.getProvidesBoundaries(window);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcWindow window) {
		return objectService.getIsDefinedBy(window);
	}

	public List<IfcPropertySet> getIsDefinedByDir(IfcWindow window) {
		return objectService.getIsDefinedByDir(window);
	}

}
