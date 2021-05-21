package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcRelAggregatesService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelAggregatesResolver implements GraphQLResolver<IfcRelAggregates> {
	@Autowired
	private IfcRelAggregatesService ifcRelAggregatesService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelAggregates relAggregates) {
		return rootService.getOwnerHistory(relAggregates);
	}

	public IfcObjectDefinition getRelatingObject(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatingObject(relAggregates);
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAggregates relAggregates) {
		return ifcRelAggregatesService.getRelatedObjects(relAggregates);
	}

}
