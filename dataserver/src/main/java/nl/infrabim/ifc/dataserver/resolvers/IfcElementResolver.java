package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcElementResolver implements GraphQLResolver<IfcElement> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcElement element) {
		return rootService.getOwnerHistory(element);
	}

	public List<Ref> getIsDecomposedByRef(IfcElement element) {
		return objectDefinitionService.getIsDecomposedByRef(element);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcElement element) {
		return objectDefinitionService.getIsDecomposedBy(element);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcElement element) {
		return objectDefinitionService.getIsDecomposedByDir(element);
	}

	public List<Ref> getDecomposesRef(IfcElement element) {
		return objectDefinitionService.getDecomposesRef(element);
	}

	public List<IfcRelAggregates> getDecomposes(IfcElement element) {
		return objectDefinitionService.getDecomposes(element);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcElement element) {
		return objectDefinitionService.getDecomposesDir(element);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcElement element) {
		return elementService.getHasAssociations(element);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcElement element) {
		return elementService.getHasOpenings(element);
	}
}
