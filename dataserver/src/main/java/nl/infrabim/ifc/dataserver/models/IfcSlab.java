package nl.infrabim.ifc.dataserver.models;

public class IfcSlab extends IfcElement {
	private IfcSlabTypeEnum predefinedType;

	public IfcSlab() {
		super();
	}

	public IfcSlab(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcSlabTypeEnum getPredefinedType() {
		return predefinedType;
	}

	public void setPredefinedType(IfcSlabTypeEnum predefinedType) {
		this.predefinedType = predefinedType;
	}

}
