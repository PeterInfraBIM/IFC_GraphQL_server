package nl.infrabim.ifc.dataserver.models;

public class IfcBooleanValue extends IfcValue {
	private Boolean booleanValue;

	public IfcBooleanValue() {
		super();
	}

	public Boolean getBooleanValue() {
		return booleanValue;
	}

	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

}
