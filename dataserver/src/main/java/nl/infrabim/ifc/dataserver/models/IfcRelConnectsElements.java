package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelConnectsElements extends IfcRoot {
	@Field("relatingElement")
	private Ref relatingElementRef;
	@Field("relatedElement")
	private Ref relatedElementRef;

	public IfcRelConnectsElements() {
		super();
	}

	public IfcRelConnectsElements(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public Ref getRelatingElementRef() {
		return relatingElementRef;
	}

	public void setRelatingElementRef(Ref relatingElementRef) {
		this.relatingElementRef = relatingElementRef;
	}

	public Ref getRelatedElementRef() {
		return relatedElementRef;
	}

	public void setRelatedElementRef(Ref relatedElementRef) {
		this.relatedElementRef = relatedElementRef;
	}

}
