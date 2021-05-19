package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;
import nl.infrabim.ifc.dataserver.services.IfcSiteService;
import nl.infrabim.ifc.dataserver.services.IfcSpatialStructureElementService;

@Component
public class IfcSiteResolver implements GraphQLResolver<IfcSite> {

	@Autowired
	private IfcSiteService siteService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcSpatialStructureElementService spatialStructureElementService;
	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcSite site) {
		return rootService.getOwnerHistory(site);
	}

	public List<Double> getRefLatitude(IfcSite site) {
		return siteService.getRefLatitude(site);
	}

	public List<Double> getRefLongitude(IfcSite site) {
		return siteService.getRefLongitude(site);
	}

	public List<Ref> getIsDecomposedByRef(IfcSite site) {
		return objectDefinitionService.getIsDecomposedByRef(site);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcSite site) {
		return objectDefinitionService.getIsDecomposedBy(site);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcSite site) {
		return objectDefinitionService.getIsDecomposedByDir(site);
	}

	public List<Ref> getDecomposesRef(IfcSite site) {
		return objectDefinitionService.getDecomposesRef(site);
	}

	public List<IfcRelAggregates> getDecomposes(IfcSite site) {
		return objectDefinitionService.getDecomposes(site);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcSite site) {
		return objectDefinitionService.getDecomposesDir(site);
	}

	public IfcElementCompositionEnum getCompositionType(IfcSite site) {
		return spatialStructureElementService.getCompositionType(site);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcSite site) {
		return productService.getObjectPlacements(site);
	}

	public List<IfcRelContainedInSpatialStructure> getContainsElements(IfcSite site) {
		return spatialStructureElementService.getContainsElements(site);
	}

	public List<IfcProduct> getContainsElementsDir(IfcSite site) {
		return spatialStructureElementService.getcontainsElementsDir(site);
	}
}
