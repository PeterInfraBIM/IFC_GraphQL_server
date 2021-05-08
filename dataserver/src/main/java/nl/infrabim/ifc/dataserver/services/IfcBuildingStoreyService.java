package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuildingStorey;
import nl.infrabim.ifc.dataserver.models.IfcRoot;

@Service
public class IfcBuildingStoreyService {

	@Autowired
	private IfcRootService rootService;

	public List<IfcBuildingStorey> getAllBuildingStoreys() {
		List<IfcBuildingStorey> allBuildingStoreys = null;
		List<IfcRoot> filterRootsByType = rootService.filterRootsByType("IfcBuildingStorey");
		if (filterRootsByType != null) {
			allBuildingStoreys = new ArrayList<>();
			for (IfcRoot r : filterRootsByType) {
				IfcBuildingStorey b = new IfcBuildingStorey();
				b.copyRootValues(r);
				allBuildingStoreys.add(b);
			}
		}
		return allBuildingStoreys;
	}

}
