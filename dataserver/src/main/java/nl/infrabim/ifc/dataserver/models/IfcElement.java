package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcElement extends IfcProduct {
	@Field("hasAssociations")
	private List<Ref> hasAssociationsRef;
	@Field("hasOpenings")
	private List<Ref> hasOpeningsRef;

	public IfcElement() {
		super();
	}

	public IfcElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getHasAssociationsRef() {
		return hasAssociationsRef;
	}

	public void setHasAssociationsRef(List<Ref> hasAssociationsRef) {
		this.hasAssociationsRef = hasAssociationsRef;
	}

	public List<Ref> getHasOpeningsRef() {
		return hasOpeningsRef;
	}

	public void setHasOpeningsRef(List<Ref> hasOpeningsRef) {
		this.hasOpeningsRef = hasOpeningsRef;
	}

}
