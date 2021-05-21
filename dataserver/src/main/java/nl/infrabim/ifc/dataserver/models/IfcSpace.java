package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcSpace extends IfcSpatialStructureElement {
	private IfcInternalOrExternalEnum interiorOrExteriorSpace;
	@Field("boundedBy")
	private List<Ref> boundedByRef;

	public IfcSpace() {
		super();
	}

	public IfcSpace(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcInternalOrExternalEnum getInteriorOrExteriorSpace() {
		return interiorOrExteriorSpace;
	}

	public void setInteriorOrExteriorSpace(IfcInternalOrExternalEnum interiorOrExteriorSpace) {
		this.interiorOrExteriorSpace = interiorOrExteriorSpace;
	}

	public List<Ref> getBoundedByRef() {
		return boundedByRef;
	}

	public void setBoundedByRef(List<Ref> boundedByRef) {
		this.boundedByRef = boundedByRef;
	}

}
