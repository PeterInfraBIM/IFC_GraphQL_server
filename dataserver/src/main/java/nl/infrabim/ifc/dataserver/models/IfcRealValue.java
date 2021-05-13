package nl.infrabim.ifc.dataserver.models;

public class IfcRealValue extends IfcValue {
	private Double realValue;

	public IfcRealValue() {
		super();
	}

	public Double getRealValue() {
		return realValue;
	}

	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}

}
