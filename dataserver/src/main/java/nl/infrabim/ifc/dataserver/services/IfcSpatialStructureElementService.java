package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcSpatialStructureElementService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcRelContainedInSpatialStructureService relContainedInSpatialStructureService;
	@Autowired
	private IfcProductService productService;

	public List<IfcSpatialStructureElement> getAllSpatialStructureElements() {
		Criteria criteriaV1 = Criteria.where("longName").exists(true);
		Criteria criteriaV2 = Criteria.where("containsElements").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2));
		return mongoTemplate.find(query, IfcSpatialStructureElement.class);
	}

	public List<IfcRelContainedInSpatialStructure> getContainsElements(
			IfcSpatialStructureElement spatialStructureElement) {
		List<IfcRelContainedInSpatialStructure> containsElements = null;
		List<Ref> containsElementsRef = spatialStructureElement.getContainsElementsRef();
		if (containsElementsRef != null) {
			containsElements = new ArrayList<>();
			for (Ref ref : containsElementsRef) {
				containsElements
						.add(relContainedInSpatialStructureService.getOneRelContainedInSpatialStructure(ref.getRef()));
			}
		}
		return containsElements;
	}

	public List<IfcProduct> getcontainsElementsDir(IfcSpatialStructureElement spatialStructureElement) {
		List<IfcProduct> containsElementsDir = null;
		List<IfcRelContainedInSpatialStructure> containsElements = getContainsElements(spatialStructureElement);
		if (containsElements != null) {
			containsElementsDir = new ArrayList<>();
			for (IfcRelContainedInSpatialStructure rel : containsElements) {
				List<Ref> relatedElementRefs = rel.getRelatedElementsRef();
				for (Ref relatedElementRef : relatedElementRefs) {
					containsElementsDir.add(productService.getOneProduct(relatedElementRef.getRef()));
				}
			}
		}
		return containsElementsDir;
	}
}
