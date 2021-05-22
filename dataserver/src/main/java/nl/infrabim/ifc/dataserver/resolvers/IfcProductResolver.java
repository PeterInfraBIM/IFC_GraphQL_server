package nl.infrabim.ifc.dataserver.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcOwnerHistory;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelAggregates;
import nl.infrabim.ifc.dataserver.services.IfcObjectDefinitionService;
import nl.infrabim.ifc.dataserver.services.IfcProductService;
import nl.infrabim.ifc.dataserver.services.IfcRootService;

@Component
public class IfcProductResolver implements GraphQLResolver<IfcProduct> {

	@Autowired
	private IfcProductService productService;
	@Autowired
	private IfcObjectDefinitionService objectDefinitionService;
	@Autowired
	private IfcRootService rootService;

	public IfcOwnerHistory getOwnerHistory(IfcProduct product) {
		return rootService.getOwnerHistory(product);
	}

	public List<IfcRelAggregates> getIsDecomposedBy(IfcProduct product) {
		return objectDefinitionService.getIsDecomposedBy(product);
	}

	public List<IfcObjectDefinition> getIsDecomposedByDir(IfcProduct product) {
		return objectDefinitionService.getIsDecomposedByDir(product);
	}

	public List<IfcRelAggregates> getDecomposes(IfcProduct product) {
		return objectDefinitionService.getDecomposes(product);
	}

	public List<IfcObjectDefinition> getDecomposesDir(IfcProduct product) {
		return objectDefinitionService.getDecomposesDir(product);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcProduct product) {
		return productService.getObjectPlacements(product);
	}

}
