package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcTypeProduct extends IfcTypeObject {
	private List<IfcRepresentationMap> representationMaps;
	private String tag;

	public IfcTypeProduct() {
		super();
	}

	public IfcTypeProduct(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<IfcRepresentationMap> getRepresentationMaps() {
		return representationMaps;
	}

	public void setRepresentationMaps(List<IfcRepresentationMap> representationMaps) {
		this.representationMaps = representationMaps;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
