package nl.infrabim.ifc.dataserver.models;

public class IfcDoor extends IfcElement {
	private Double overallHeight;
	private Double overallWidth;

	public IfcDoor() {
		super();
	}

	public IfcDoor(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public Double getOverallHeight() {
		return overallHeight;
	}

	public void setOverallHeight(Double overallHeight) {
		this.overallHeight = overallHeight;
	}

	public Double getOverallWidth() {
		return overallWidth;
	}

	public void setOverallWidth(Double overallWidth) {
		this.overallWidth = overallWidth;
	}

}
