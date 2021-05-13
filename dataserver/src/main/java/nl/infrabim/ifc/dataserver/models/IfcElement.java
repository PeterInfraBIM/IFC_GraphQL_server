package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcElement extends IfcProduct {
	@Field("hasAssociations")
	private List<Ref> hasAssociationsRef;

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

}
