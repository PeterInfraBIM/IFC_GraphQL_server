package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelDefinesByType extends IfcRoot {
	@Field("relatedObjects")
	private List<Ref> relatedObjectsRef;
	@Field("relatingType")
	private Ref relatingTypeRef;

	public IfcRelDefinesByType() {
		super();
	}

	public List<Ref> getRelatedObjectsRef() {
		return relatedObjectsRef;
	}

	public void setRelatedObjectsRef(List<Ref> relatedObjectsRef) {
		this.relatedObjectsRef = relatedObjectsRef;
	}

	public Ref getRelatingTypeRef() {
		return relatingTypeRef;
	}

	public void setRelatingTypeRef(Ref relatingTypeRef) {
		this.relatingTypeRef = relatingTypeRef;
	}

}
