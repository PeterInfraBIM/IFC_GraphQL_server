package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcCartesianPoint {
	private List<Double> coordinates;

	public IfcCartesianPoint() {
		super();
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

}
