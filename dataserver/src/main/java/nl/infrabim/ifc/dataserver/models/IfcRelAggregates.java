package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Ifc_json_2")
public class IfcRelAggregates extends IfcRoot {
	@Field("relatingObject")
	private Ref relatingObjectRef;
	@Field("relatedObjects")
	private List<Ref> relatedObjectsRef;

	public IfcRelAggregates() {
		super();
	}

	public IfcRelAggregates(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public Ref getRelatingObjectRef() {
		return relatingObjectRef;
	}

	public void setRelatingObjectRef(Ref relatingObjectRef) {
		this.relatingObjectRef = relatingObjectRef;
	}

	public List<Ref> getRelatedObjectsRef() {
		return relatedObjectsRef;
	}

	public void setRelatedObjectsRef(List<Ref> relatedObjectsRef) {
		this.relatedObjectsRef = relatedObjectsRef;
	}

	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}
}
