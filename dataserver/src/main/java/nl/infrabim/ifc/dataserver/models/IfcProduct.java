package nl.infrabim.ifc.dataserver.models;

public class IfcProduct extends IfcObjectDefinition {
	private IfcLocalPlacement objectPlacement;
	private IfcProductRepresentation representation;

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

	public IfcProductRepresentation getRepresentation() {
		return representation;
	}

	public void setRepresentation(IfcProductRepresentation representation) {
		this.representation = representation;
	}

}
