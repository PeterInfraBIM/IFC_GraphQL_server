package nl.infrabim.ifc.dataserver.models;

public class IfcLabel extends IfcValue {
	private String labelValue;

	public IfcLabel() {
		super();
	}

	public String getLabelValue() {
		return labelValue;
	}

	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}

}
