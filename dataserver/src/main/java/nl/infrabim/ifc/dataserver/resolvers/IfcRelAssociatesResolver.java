package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelAssociatesResolver implements GraphQLResolver<IfcRelAssociates> {
	@Autowired
	private IfcRelAssociatesService relAssociatesService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelAssociates relAssociates) {
		return rootService.getOwnerHistory(relAssociates);
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAssociates relAssociates) {
		return relAssociatesService.getRelatedObjects(relAssociates);
	}

}
