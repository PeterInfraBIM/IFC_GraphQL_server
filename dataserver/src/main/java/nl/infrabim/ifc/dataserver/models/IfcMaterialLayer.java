package nl.infrabim.ifc.dataserver.models;

public class IfcMaterialLayer {
	private String type;
	private IfcMaterial material;
	private Double layerThickness;

	public IfcMaterialLayer() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IfcMaterial getMaterial() {
		return material;
	}

	public void setMaterial(IfcMaterial material) {
		this.material = material;
	}

	public Double getLayerThickness() {
		return layerThickness;
	}

	public void setLayerThickness(Double layerThickness) {
		this.layerThickness = layerThickness;
	}

}
