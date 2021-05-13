package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcMaterialLayerSet {
	private String type;
	private List<IfcMaterialLayer> materialLayers;

	public IfcMaterialLayerSet() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<IfcMaterialLayer> getMaterialLayers() {
		return materialLayers;
	}

	public void setMaterialLayers(List<IfcMaterialLayer> materialLayers) {
		this.materialLayers = materialLayers;
	}

}
