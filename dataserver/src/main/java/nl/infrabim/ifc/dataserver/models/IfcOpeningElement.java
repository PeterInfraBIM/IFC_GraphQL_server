package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcOpeningElement extends IfcFeatureElementSubtraction {
	@Field("hasFillings")
	private List<Ref> hasFillingsRef;

	public IfcOpeningElement() {
		super();
	}

	public IfcOpeningElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getHasFillingsRef() {
		return hasFillingsRef;
	}

	public void setHasFillingsRef(List<Ref> hasFillingsRef) {
		this.hasFillingsRef = hasFillingsRef;
	}

}
