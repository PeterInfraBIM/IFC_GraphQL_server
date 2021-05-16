package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Ifc_json_2")
public class IfcRelFillsElement extends IfcRoot {
	@Field("relatingOpeningElement")
	private Ref relatingOpeningElementRef;
	@Field("relatedBuildingElement")
	private Ref relatedBuildingElementRef;

	public IfcRelFillsElement() {
		super();
	}

	public IfcRelFillsElement(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public Ref getRelatingOpeningElementRef() {
		return relatingOpeningElementRef;
	}

	public void setRelatingOpeningElementRef(Ref relatingOpeningElementRef) {
		this.relatingOpeningElementRef = relatingOpeningElementRef;
	}

	public Ref getRelatedBuildingElementRef() {
		return relatedBuildingElementRef;
	}

	public void setRelatedBuildingElementRef(Ref relatedBuildingElementRef) {
		this.relatedBuildingElementRef = relatedBuildingElementRef;
	}

}
