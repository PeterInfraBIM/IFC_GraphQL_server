package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.services.IfcRelAssociatesService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelAssociatesMaterialResolver implements GraphQLResolver<IfcRelAssociatesMaterial> {
	@Autowired
	private IfcRelAssociatesService relAssociatesService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelAssociatesMaterial relAssociatesMaterial) {
		return rootService.getOwnerHistory(relAssociatesMaterial);
	}

	public List<IfcObjectDefinition> getRelatedObjects(IfcRelAssociatesMaterial relAssociatesMaterial) {
		return relAssociatesService.getRelatedObjects(relAssociatesMaterial);
	}

}
