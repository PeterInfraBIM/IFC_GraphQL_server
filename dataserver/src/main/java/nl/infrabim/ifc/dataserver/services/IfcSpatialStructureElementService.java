package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.repositories.IfcSpatialStructureElementRepository;

@Service
public class IfcSpatialStructureElementService {
	@Autowired
	private IfcSpatialStructureElementRepository spatialStructureElementRepository;
	@Autowired
	private IfcRelContainedInSpatialStructureService relContainedInSpatialStructureService;
	@Autowired
	private IfcProductService productService;

	public IfcElementCompositionEnum getCompositionType(IfcSpatialStructureElement spatialStructureElement) {
		Optional<IfcSpatialStructureElement> findById = spatialStructureElementRepository
				.findById(spatialStructureElement.getId());
		if (findById.isPresent()) {
			String compositionType = findById.get().getCompositionType();
			if (compositionType != null) {
				return IfcElementCompositionEnum.valueOf(compositionType);
			}
		}
		return null;
	}

	public List<IfcSpatialStructureElement> getAllSpatialStructureElements() {
		List<IfcSpatialStructureElement> filteredList = null;
		for (IfcSpatialStructureElement candidate : spatialStructureElementRepository.findAll()) {
			if (candidate.getCompositionType() != null) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public List<Ref> getcontainsElementsRef(IfcSpatialStructureElement spatialStructureElement) {
		Optional<IfcSpatialStructureElement> findById = spatialStructureElementRepository
				.findById(spatialStructureElement.getId());
		if (findById.isPresent()) {
			return findById.get().getContainsElementsRef();
		}
		return null;
	}

	public List<IfcRelContainedInSpatialStructure> getContainsElements(
			IfcSpatialStructureElement spatialStructureElement) {
		List<IfcRelContainedInSpatialStructure> containsElements = null;
		Optional<List<Ref>> refList = Optional.ofNullable(getcontainsElementsRef(spatialStructureElement));
		if (refList.isPresent()) {
			containsElements = new ArrayList<>();
			List<Ref> relatingObjectRef = refList.get();
			for (Ref ref : relatingObjectRef) {
				containsElements.add(relContainedInSpatialStructureService
						.getRelContainedInSpatialStructureByGlobalId(ref.getRef()));
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
				List<Ref> relatedElementRefs = rel.getRelatedElements();
				for (Ref relatedElementRef : relatedElementRefs) {
					containsElementsDir.add(productService.getProductByGlobalId(relatedElementRef.getRef()));
				}
			}
		}
		return containsElementsDir;
	}
}
