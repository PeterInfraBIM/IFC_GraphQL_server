package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcElementCompositionEnum;
import nl.infrabim.ifc.dataserver.models.IfcSpatialStructureElement;
import nl.infrabim.ifc.dataserver.repositories.IfcSpatialStructureElementRepository;

@Service
public class IfcSpatialStructureElementService {
	@Autowired
	private IfcSpatialStructureElementRepository spatialStructureElementRepository;

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
}
