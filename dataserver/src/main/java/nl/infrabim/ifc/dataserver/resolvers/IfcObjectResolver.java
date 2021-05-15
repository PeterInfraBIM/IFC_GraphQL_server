package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcObjectResolver implements GraphQLResolver<IfcObject> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcObject object) {
		return rootService.getOwnerHistory(object);
	}

	public List<Ref> getIsDecomposedByRef(IfcObject object) {
		return objectDefinitionService.getIsDecomposedByRef(object);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcObject object) {
		return objectDefinitionService.getIsDecomposedBy(object);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcObject object) {
		return objectDefinitionService.getIsDecomposedByDir(object);
	}

	public List<Ref> getDecomposesRef(IfcObject object) {
		return objectDefinitionService.getDecomposesRef(object);
	}

	public List<IfcRelAggregates> getDecomposes(IfcObject object) {
		return objectDefinitionService.getDecomposes(object);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcObject object) {
		return objectDefinitionService.getDecomposesDir(object);
	}
	
	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcObject object){
		return objectService.getIsDefinedBy(object);
	}
}
