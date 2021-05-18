package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcProject extends IfcObject {
	@Field("representationContexts")
	private List<Ref> representationContextsRef;

	public IfcProject() {
		super();
	}

	public IfcProject(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getRepresentationContextsRef() {
		return representationContextsRef;
	}

	public void setRepresentationContextsRef(List<Ref> representationContextsRef) {
		this.representationContextsRef = representationContextsRef;
	}

}
