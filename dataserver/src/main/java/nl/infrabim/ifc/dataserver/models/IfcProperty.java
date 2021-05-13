package nl.infrabim.ifc.dataserver.models;

public class IfcProperty {
	private String type;
	private String name;
	private String description;
	private IfcValue nominalValue;

	public IfcProperty() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IfcValue getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(IfcValue nominalValue) {
		this.nominalValue = nominalValue;
	}

}
