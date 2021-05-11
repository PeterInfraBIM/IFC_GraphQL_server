package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcRelAggregatesService;

@Component
public class IfcRelAggregatesResolver implements GraphQLResolver<IfcRelAggregates> {
	@Autowired
	private IfcRelAggregatesService ifcRelAggregatesService;

	public Ref getRelatingObjectRef(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatingObjectRef(relAggregates);
	}

	public IfcObjectDefinition getRelatingObject(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatingObject(relAggregates);
	}

	public List<Ref> getRelatedObjectsRef(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatedObjectsRef(relAggregates);
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatedObjects(relAggregates);
	}

}
