package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcPropertyDefinition extends IfcRoot {
	@Field("hasAssociations")
	private List<Ref> hasAssociationsRef;

	public IfcPropertyDefinition() {
		super();
	}

	public IfcPropertyDefinition(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public List<Ref> getHasAssociationsRef() {
		return hasAssociationsRef;
	}

	public void setHasAssociationsRef(List<Ref> hasAssociationsRef) {
		this.hasAssociationsRef = hasAssociationsRef;
	}

}
