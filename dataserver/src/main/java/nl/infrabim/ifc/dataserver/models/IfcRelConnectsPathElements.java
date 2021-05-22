package nl.infrabim.ifc.dataserver.models;

public class IfcRelConnectsPathElements extends IfcRelConnectsElements {
	private IfcConnectionTypeEnum relatedConnectionType;
	private IfcConnectionTypeEnum relatingConnectionType;

	public IfcRelConnectsPathElements() {
		super();
	}

	public IfcRelConnectsPathElements(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public IfcConnectionTypeEnum getRelatedConnectionType() {
		return relatedConnectionType;
	}

	public void setRelatedConnectionType(IfcConnectionTypeEnum relatedConnectionType) {
		this.relatedConnectionType = relatedConnectionType;
	}

	public IfcConnectionTypeEnum getRelatingConnectionType() {
		return relatingConnectionType;
	}

	public void setRelatingConnectionType(IfcConnectionTypeEnum relatingConnectionType) {
		this.relatingConnectionType = relatingConnectionType;
	}

}
