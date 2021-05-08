package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcDirection {
	private List<Double> directionRatios;

	public IfcDirection() {
		super();
	}

	public List<Double> getDirectionRatios() {
		return directionRatios;
	}

	public void setDirectionRatios(List<Double> directionRatios) {
		this.directionRatios = directionRatios;
	}

}
