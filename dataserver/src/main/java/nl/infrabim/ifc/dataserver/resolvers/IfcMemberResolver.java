package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcMember;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;
import nl.infrabim.ifc.dataserver.models.IfcRelSpaceBoundary;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.services.IfcElementService;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcMemberResolver implements GraphQLResolver<IfcMember> {

	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcElementService elementService;
	@Autowired
	private IfcObjectService objectService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcMember member) {
		return rootService.getOwnerHistory(member);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcMember member) {
		return objectDefinitionService.getIsDecomposedBy(member);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcMember member) {
		return objectDefinitionService.getIsDecomposedByDir(member);
	}

	public List<IfcRelAggregates> getDecomposes(IfcMember member) {
		return objectDefinitionService.getDecomposes(member);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcMember member) {
		return objectDefinitionService.getDecomposesDir(member);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcMember member) {
		return productService.getObjectPlacements(member);
	}

	public List<IfcRelAssociatesMaterial> getHasAssociations(IfcMember member) {
		return elementService.getHasAssociations(member);
	}

	public List<IfcRelVoidsElement> getHasOpenings(IfcMember member) {
		return elementService.getHasOpenings(member);
	}

	public List<IfcRelFillsElement> getFillsVoids(IfcMember member) {
		return elementService.getFillsVoids(member);
	}
	
	public List<IfcRelSpaceBoundary> getProvidesBoundaries(IfcMember member) {
		return elementService.getProvidesBoundaries(member);
	}

	public List<IfcRelDefinesByProperties> getIsDefinedBy(IfcMember member) {
		return objectService.getIsDefinedBy(member);
	}
	
	public List<IfcPropertySet> getIsDefinedByDir(IfcMember member) {
		return objectService.getIsDefinedByDir(member);
	}

}
