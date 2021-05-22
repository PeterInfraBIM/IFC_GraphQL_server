package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcProject extends IfcObject {
	private String longName;
	private String phase;
	@Field("representationContexts")
	private List<Ref> representationContextsRef;

	public IfcProject() {
		super();
	}

	public IfcProject(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public List<Ref> getRepresentationContextsRef() {
		return representationContextsRef;
	}

	public void setRepresentationContextsRef(List<Ref> representationContextsRef) {
		this.representationContextsRef = representationContextsRef;
	}

}
