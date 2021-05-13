package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcObject extends IfcObjectDefinition {
	@Field("isDefinedBy")
	private List<Ref> isDefinedByRef;

	public IfcObject() {
		super();
	}

	public IfcObject(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getIsDefinedByRef() {
		return isDefinedByRef;
	}

	public void setIsDefinedByRef(List<Ref> isDefinedByRef) {
		this.isDefinedByRef = isDefinedByRef;
	}

}
