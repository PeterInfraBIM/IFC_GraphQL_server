package nl.infrabim.ifc.dataserver.models;

public class IfcBuildingStorey extends IfcSpatialStructureElement {

	private Float elevation;

	public IfcBuildingStorey() {
		super();
	}

	public IfcBuildingStorey(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public Float getElevation() {
		return elevation;
	}

	public void setElevation(Float elevation) {
		this.elevation = elevation;
	}

	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}
}
