package nl.infrabim.ifc.dataserver.models;

public class IfcAxis2Placement3D {
	private IfcCartesianPoint location;
	private IfcDirection axis;
	private IfcDirection refDirection;

	public IfcAxis2Placement3D() {
	}

	public IfcCartesianPoint getLocation() {
		return location;
	}

	public void setLocation(IfcCartesianPoint location) {
		this.location = location;
	}

	public IfcDirection getAxis() {
		return axis;
	}

	public void setAxis(IfcDirection axis) {
		this.axis = axis;
	}

	public IfcDirection getRefDirection() {
		return refDirection;
	}

	public void setRefDirection(IfcDirection refDirection) {
		this.refDirection = refDirection;
	}

}
