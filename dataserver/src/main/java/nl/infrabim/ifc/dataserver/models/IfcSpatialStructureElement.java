package nl.infrabim.ifc.dataserver.models;

public class IfcSpatialStructureElement extends IfcProduct {

	private String compositionType;

	public IfcSpatialStructureElement() {
		super();
	}

	public IfcSpatialStructureElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public String getCompositionType() {
		return compositionType;
	}

	public void setCompositionType(String compositionType) {
		this.compositionType = compositionType;
	}

}
