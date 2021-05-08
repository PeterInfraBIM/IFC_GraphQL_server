package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;
import nl.infrabim.ifc.dataserver.models.IfcRoot;

@Service
public class IfcBuildingService {

	@Autowired
	private IfcRootService rootService;

	public List<IfcBuilding> getAllBuildings() {
		List<IfcBuilding> allBuildings = null;
		List<IfcRoot> filterRootsByType = rootService.filterRootsByType("IfcBuilding");
		if (filterRootsByType != null) {
			allBuildings = new ArrayList<>();
			for (IfcRoot r : filterRootsByType) {
				IfcBuilding b = new IfcBuilding();
				b.copyRootValues(r);
				allBuildings.add(b);
			}
		}
		return allBuildings;
	}

}
