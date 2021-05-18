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
		Optional<IfcSite> findById = siteRepository.findById(site.get_Id());
		if (findById.isPresent()) {
			return findById.get().getRefLatitude();
		}
		return null;
	}

	public List<Double> getRefLongitude(IfcSite site) {
		Optional<IfcSite> findById = siteRepository.findById(site.get_Id());
		if (findById.isPresent()) {
			return findById.get().getRefLongitude();
		}
		return null;
	}

}
