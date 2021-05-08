package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcSpatialStructureElementResolver implements GraphQLResolver<IfcSpatialStructureElement> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;

	public List<Ref> getIsDecomposedByRef(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedByRef(spatialStructureElement);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedBy(spatialStructureElement);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getIsDecomposedByDir(spatialStructureElement);
	}

	public List<Ref> getDecomposesRef(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposesRef(spatialStructureElement);
	}

	public List<IfcRelAggregates> getDecomposes(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposes(spatialStructureElement);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcSpatialStructureElement spatialStructureElement) {
		return objectDefinitionService.getDecomposesDir(spatialStructureElement);
	}

	public IfcElementCompositionEnum getCompositionType(IfcSpatialStructureElement spatialStructureElement) {
		return spatialStructureElementService.getCompositionType(spatialStructureElement);
	}

}