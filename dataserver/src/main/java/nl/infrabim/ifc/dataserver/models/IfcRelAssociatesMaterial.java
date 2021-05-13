package nl.infrabim.ifc.dataserver.models;

public class IfcRelAssociatesMaterial extends IfcRelAssociates {
	private IfcMaterialLayerSetUsage relatingMaterial;

	public IfcRelAssociatesMaterial() {
		super();
	}

	public IfcRelAssociatesMaterial(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcMaterialLayerSetUsage getRelatingMaterial() {
		return relatingMaterial;
	}

	public void setRelatingMaterial(IfcMaterialLayerSetUsage relatingMaterial) {
		this.relatingMaterial = relatingMaterial;
	}

}
