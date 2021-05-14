package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelVoidsElement extends IfcRoot {
	@Field("relatingBuildingElement")
	private Ref relatingBuildingElementRef;
	@Field("relatedOpeningElement")
	private Ref relatedOpeningElementRef;

	public IfcRelVoidsElement() {
		super();
	}

	public IfcRelVoidsElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public Ref getRelatingBuildingElementRef() {
		return relatingBuildingElementRef;
	}

	public void setRelatingBuildingElementRef(Ref relatingBuildingElementRef) {
		this.relatingBuildingElementRef = relatingBuildingElementRef;
	}

	public Ref getRelatedOpeningElementRef() {
		return relatedOpeningElementRef;
	}

	public void setRelatedOpeningElementRef(Ref relatedOpeningElementRef) {
		this.relatedOpeningElementRef = relatedOpeningElementRef;
	}

}
