package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcTypeObjectService;

@Component
public class IfcTypeObjectResolver implements GraphQLResolver<IfcTypeObject> {
	@Autowired
	private IfcTypeObjectService typeObjectService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcTypeObject typeObject) {
		return rootService.getOwnerHistory(typeObject);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcTypeObject typeObject) {
		return objectDefinitionService.getIsDecomposedBy(typeObject);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcTypeObject typeObject) {
		return objectDefinitionService.getIsDecomposedByDir(typeObject);
	}

	public List<IfcRelAggregates> getDecomposes(IfcTypeObject typeObject) {
		return objectDefinitionService.getDecomposes(typeObject);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcTypeObject typeObject) {
		return objectDefinitionService.getDecomposesDir(typeObject);
	}

	public List<IfcRelDefinesByType> getObjectTypeOf(IfcTypeObject typeObject) {
		return typeObjectService.getObjectTypeOf(typeObject);
	}

	public List<IfcObject> getObjectTypeOfDir(IfcTypeObject typeObject) {
		return typeObjectService.getObjectTypeOfDir(typeObject);
	}

	public List<IfcPropertySetDefinition> getHasPropertySets(IfcTypeObject typeObject) {
		return typeObjectService.getHasPropertySets(typeObject);
	}
}
