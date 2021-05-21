package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcSpatialStructureElement extends IfcProduct {
	private String longName;
	private IfcElementCompositionEnum compositionType;
	@Field("containsElements")
	private List<Ref> containsElementsRef;

	public IfcSpatialStructureElement() {
		super();
	}

	public IfcSpatialStructureElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public IfcElementCompositionEnum getCompositionType() {
		return compositionType;
	}

	public void setCompositionType(IfcElementCompositionEnum compositionType) {
		this.compositionType = compositionType;
	}

	public List<Ref> getContainsElementsRef() {
		return containsElementsRef;
	}

	public void setContainsElementsRef(List<Ref> containsElementsRef) {
		this.containsElementsRef = containsElementsRef;
	}

}
