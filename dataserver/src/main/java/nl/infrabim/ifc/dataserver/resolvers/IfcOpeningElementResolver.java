package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOpeningElement;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.IfcWallStandardCase;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;

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

	public List<Ref> getIsDecomposedByRef(IfcOpeningElement openingElement) {
		return objectDefinitionService.getIsDecomposedByRef(openingElement);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcOpeningElement openingElement) {
		return objectDefinitionService.getIsDecomposedBy(openingElement);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcOpeningElement openingElement) {
		return objectDefinitionService.getIsDecomposedByDir(openingElement);
	}

	public List<Ref> getDecomposesRef(IfcOpeningElement openingElement) {
		return objectDefinitionService.getDecomposesRef(openingElement);
	}

	public List<IfcRelAggregates> getDecomposes(IfcOpeningElement openingElement) {
		return objectDefinitionService.getDecomposes(openingElement);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcOpeningElement openingElement) {
		return objectDefinitionService.getDecomposesDir(openingElement);
	}

	public IfcLocalPlacement getObjectPlacement(IfcOpeningElement openingElement) {
		return productService.getObjectPlacement(openingElement);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcOpeningElement openingElement) {
		return elementService.getHasAssociations(openingElement);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcOpeningElement openingElement) {
		return elementService.getHasOpenings(openingElement);
	}
	
	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcOpeningElement openingElement) {
		return objectService.getIsDefinedBy(openingElement);
	}

}
