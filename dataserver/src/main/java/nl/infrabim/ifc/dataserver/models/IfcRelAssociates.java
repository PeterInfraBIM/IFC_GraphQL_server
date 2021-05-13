package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelAssociates extends IfcRoot {
	@Field("relatedObjects")
	private List<Ref> relatedObjectsRef;

	public IfcRelAssociates() {
		super();
	}

	public IfcRelAssociates(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getRelatedObjectsRef() {
		return relatedObjectsRef;
	}

	public void setRelatedObjectsRef(List<Ref> relatedObjectsRef) {
		this.relatedObjectsRef = relatedObjectsRef;
	}

}
