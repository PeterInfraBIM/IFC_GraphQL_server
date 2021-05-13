package nl.infrabim.ifc.dataserver.models;

public class IfcMaterialLayerSetUsage {
	private String type;
	private IfcMaterialLayerSet forLayerSet;
	private IfcLayerSetDirectionEnum layerSetDirection;
	private IfcDirectionSenseEnum directionSense;
	private Double offsetFromReferenceLine;

	public IfcMaterialLayerSetUsage() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IfcMaterialLayerSet getForLayerSet() {
		return forLayerSet;
	}

	public void setForLayerSet(IfcMaterialLayerSet forLayerSet) {
		this.forLayerSet = forLayerSet;
	}

	public IfcLayerSetDirectionEnum getLayerSetDirection() {
		return layerSetDirection;
	}

	public void setLayerSetDirection(IfcLayerSetDirectionEnum layerSetDirection) {
		this.layerSetDirection = layerSetDirection;
	}

	public IfcDirectionSenseEnum getDirectionSense() {
		return directionSense;
	}

	public void setDirectionSense(IfcDirectionSenseEnum directionSense) {
		this.directionSense = directionSense;
	}

	public Double getOffsetFromReferenceLine() {
		return offsetFromReferenceLine;
	}

	public void setOffsetFromReferenceLine(Double offsetFromReferenceLine) {
		this.offsetFromReferenceLine = offsetFromReferenceLine;
	}

}
