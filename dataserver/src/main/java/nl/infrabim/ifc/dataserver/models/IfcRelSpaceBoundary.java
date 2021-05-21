package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelSpaceBoundary extends IfcRoot {
	@Field("relatingSpace")
	private Ref relatingSpaceRef;
	@Field("relatedBuildingElement")
	private Ref relatedBuildingElementRef;

	public IfcRelSpaceBoundary() {
		super();
	}

	public IfcRelSpaceBoundary(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public Ref getRelatingSpaceRef() {
		return relatingSpaceRef;
	}

	public void setRelatingSpaceRef(Ref relatingSpaceRef) {
		this.relatingSpaceRef = relatingSpaceRef;
	}

	public Ref getRelatedBuildingElementRef() {
		return relatedBuildingElementRef;
	}

	public void setRelatedBuildingElementRef(Ref relatedBuildingElementRef) {
		this.relatedBuildingElementRef = relatedBuildingElementRef;
	}

}
