package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByType;
import nl.infrabim.ifc.dataserver.services.IfcRelDefinesByTypeService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcRelDefinesByTypeResolver implements GraphQLResolver<IfcRelDefinesByType> {
	@Autowired
	private IfcRelDefinesByTypeService relDefinesByTypeService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcRelDefinesByType relDefinesByType) {
		return rootService.getOwnerHistory(relDefinesByType);
	}

	public List<IfcObject> getRelatedObjects(IfcRelDefinesByType relDefinesByType) {
		return relDefinesByTypeService.getRelatedObjects(relDefinesByType);
	}
}
