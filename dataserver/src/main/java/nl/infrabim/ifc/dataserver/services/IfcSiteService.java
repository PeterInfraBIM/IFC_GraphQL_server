package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.repositories.IfcSiteRepository;

@Service
public class IfcSiteService {

	@Autowired
	private IfcRootService rootService;

	@Autowired
	private IfcSiteRepository siteRepository;

	public List<IfcSite> getAllSites() {
		List<IfcSite> allSites = null;
		List<IfcRoot> filterRootsByType = rootService.filterRootsByType("IfcSite");
		if (filterRootsByType != null) {
			allSites = new ArrayList<>();
			for (IfcRoot r : filterRootsByType) {
				IfcSite s = new IfcSite();
				s.copyRootValues(r);
				allSites.add(s);
			}
		}
		return allSites;
	}

	public List<Double> getRefLatitude(IfcSite site) {
		Optional<IfcSite> findById = siteRepository.findById(site.getId());
		if (findById.isPresent()) {
			return findById.get().getRefLatitude();
		}
		return null;
	}

	public List<Double> getRefLongitude(IfcSite site) {
		Optional<IfcSite> findById = siteRepository.findById(site.getId());
		if (findById.isPresent()) {
			return findById.get().getRefLongitude();
		}
		return null;
	}

//	public List<Ref> getIsDecomposedByRef(IfcSite site) {
//		Optional<IfcSite> findById = siteRepository.findById(site.getId());
//		if (findById.isPresent()) {
//			return findById.get().getIsDecomposedByRef();
//		}
//		return null;
//	}
//
//	public List<Ref> getDecomposesRef(IfcSite site) {
//		Optional<IfcSite> findById = siteRepository.findById(site.getId());
//		if (findById.isPresent()) {
//			return findById.get().getDecomposesRef();
//		}
//		return null;
//	}
//
//	public List<IfcRelAggregates> getIsDecomposedBy(IfcSite site) {
//		List<IfcRelAggregates> isDecomposedBy = null;
//		Optional<List<Ref>> refList = Optional.ofNullable(getIsDecomposedByRef(site));
//		if (refList.isPresent()) {
//			isDecomposedBy = new ArrayList<>();
//			List<Ref> relatedObjectsRef = refList.get();
//			for (Ref ref : relatedObjectsRef) {
//				isDecomposedBy.add(relAggregatesService.getRelAggregatesByGlobalId(ref.getRef()));
//			}
//		}
//		return isDecomposedBy;
//	}
//
//	public List<IfcRelAggregates> getDecomposes(IfcSite site) {
//		List<IfcRelAggregates> decomposes = null;
//		Optional<List<Ref>> refList = Optional.ofNullable(getDecomposesRef(site));
//		if (refList.isPresent()) {
//			decomposes = new ArrayList<>();
//			List<Ref> relatingObjectRef = refList.get();
//			for (Ref ref : relatingObjectRef) {
//				decomposes.add(relAggregatesService.getRelAggregatesByGlobalId(ref.getRef()));
//			}
//		}
//		return decomposes;
//	}
//
//	public List<IfcRoot> getIsDecomposedByDir(IfcSite site) {
//		List<IfcRoot> isDecomposedByDir = null;
//		List<IfcRelAggregates> isDecomposedBy = getIsDecomposedBy(site);
//		if (isDecomposedBy != null) {
//			isDecomposedByDir = new ArrayList<>();
//			for (IfcRelAggregates rel : isDecomposedBy) {
//				List<Ref> relatedObjectsRef = rel.getRelatedObjectsRef();
//				for (Ref ref : relatedObjectsRef) {
//					isDecomposedByDir.add(rootService.getRootByGlobalId(ref.getRef()));
//				}
//			}
//		}
//		return isDecomposedByDir;
//	}
//
//	public List<IfcRoot> getDecomposesDir(IfcSite site) {
//		List<IfcRoot> decomposesDir = null;
//		List<IfcRelAggregates> decomposes = getDecomposes(site);
//		if (decomposes != null) {
//			decomposesDir = new ArrayList<>();
//			for (IfcRelAggregates rel : decomposes) {
//				Ref relatedObjectsRef = rel.getRelatingObjectRef();
//				decomposesDir.add(rootService.getRootByGlobalId(relatedObjectsRef.getRef()));
//			}
//		}
//		return decomposesDir;
//	}
//
//	public IfcElementCompositionEnum getCompositionType(IfcSite site) {
//		Optional<IfcSpatialStructureElement> findById = spatialStructureElementRepository.findById(site.getId());
//		if (findById.isPresent()) {
//			String compositionType = findById.get().getCompositionType();
//			if (compositionType != null) {
//				return IfcElementCompositionEnum.valueOf(compositionType);
//			}
//		}
//		return null;
//	}

}
