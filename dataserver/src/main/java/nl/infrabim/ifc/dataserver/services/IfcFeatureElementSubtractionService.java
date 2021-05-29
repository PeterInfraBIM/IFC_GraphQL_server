package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcFeatureElementSubtraction;
import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcFeatureElementSubtractionService {
	@Autowired
	private IfcRelVoidsElementService relVoidsElementService;

	public List<IfcRelVoidsElement> getVoidsElements(IfcFeatureElementSubtraction featureElementSubtraction) {
		List<IfcRelVoidsElement> voidsElements = null;
		List<Ref> voidsElementsRef = featureElementSubtraction.getVoidsElementsRef();
		if (voidsElementsRef != null) {
			voidsElements = new ArrayList<>();
			for (Ref ref : voidsElementsRef) {
				voidsElements.add(relVoidsElementService.getOneRelVoidsElement(ref.getRef()));
			}
		}
		return voidsElements;
	}

}
