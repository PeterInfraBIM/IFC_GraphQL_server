package nl.infrabim.ifc.dataserver.models;

public class IfcProduct extends IfcObjectDefinition {
	private IfcLocalPlacement objectPlacement;

	public IfcProduct() {
		super();
	}

	public IfcProduct(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcLocalPlacement getObjectPlacement() {
		return objectPlacement;
	}

	public void setObjectPlacement(IfcLocalPlacement objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

}
