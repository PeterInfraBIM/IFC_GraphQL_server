package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcRelContainedInSpatialStructureService;

@Component
public class IfcRelContainedInSpatialStructureResolver implements GraphQLResolver<IfcRelContainedInSpatialStructure> {
	@Autowired
	private IfcRelContainedInSpatialStructureService relContainedInSpatialStructureService;

	public Ref getRelatingStructure(IfcRelContainedInSpatialStructure relContainedInSpatialStructure) {
		return relContainedInSpatialStructureService.getRelatingStructure(relContainedInSpatialStructure);
	}

	public List<Ref> getRelatedElements(IfcRelContainedInSpatialStructure relContainedInSpatialStructure) {
		return relContainedInSpatialStructureService.getRelatedElements(relContainedInSpatialStructure);
	}

}
