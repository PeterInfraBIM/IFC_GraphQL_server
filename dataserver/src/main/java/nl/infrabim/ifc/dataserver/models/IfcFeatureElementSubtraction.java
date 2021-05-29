package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcFeatureElementSubtraction extends IfcElement {
	@Field("voidsElements")
	private List<Ref> voidsElementsRef;

	public IfcFeatureElementSubtraction() {
		super();
	}

	public IfcFeatureElementSubtraction(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getVoidsElementsRef() {
		return voidsElementsRef;
	}

	public void setVoidsElementsRef(List<Ref> voidsElementsRef) {
		this.voidsElementsRef = voidsElementsRef;
	}

}
