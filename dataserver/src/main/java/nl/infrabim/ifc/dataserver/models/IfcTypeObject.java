package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcTypeObject extends IfcObjectDefinition {
	private String applicableOccurrence;
	@Field("hasPropertySets")
	private List<Ref> hasPropertySetsRef;
	@Field("objectTypeOf")
	private List<Ref> objectTypeOfRef;

	public IfcTypeObject() {
		super();
	}

	public IfcTypeObject(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public String getApplicableOccurrence() {
		return applicableOccurrence;
	}

	public void setApplicableOccurrence(String applicableOccurrence) {
		this.applicableOccurrence = applicableOccurrence;
	}

	public List<Ref> getHasPropertySetsRef() {
		return hasPropertySetsRef;
	}

	public void setHasPropertySetsRef(List<Ref> hasPropertySetsRef) {
		this.hasPropertySetsRef = hasPropertySetsRef;
	}

	public List<Ref> getObjectTypeOfRef() {
		return objectTypeOfRef;
	}

	public void setObjectTypeOfRef(List<Ref> objectTypeOfRef) {
		this.objectTypeOfRef = objectTypeOfRef;
	}

}
