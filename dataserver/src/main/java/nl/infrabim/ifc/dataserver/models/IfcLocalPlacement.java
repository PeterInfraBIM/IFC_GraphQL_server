package nl.infrabim.ifc.dataserver.models;

public class IfcLocalPlacement {

	private IfcLocalPlacement placementRelTo;

	private IfcAxis2Placement3D relativePlacement;

	public IfcLocalPlacement() {
		super();
	}

	public IfcLocalPlacement getPlacementRelTo() {
		return placementRelTo;
	}

	public void setPlacementRelTo(IfcLocalPlacement placementRelTo) {
		this.placementRelTo = placementRelTo;
	}

	public IfcAxis2Placement3D getRelativePlacement() {
		return relativePlacement;
	}

	public void setRelativePlacement(IfcAxis2Placement3D relativePlacement) {
		this.relativePlacement = relativePlacement;
	}

}
