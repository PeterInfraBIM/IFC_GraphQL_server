package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRepresentationMap {
	private IfcAxis2Placement3D mappingOrigin;
	@Field("mappedRepresentation")
	private Ref mappedRepresentationRef;

	public IfcRepresentationMap() {
		super();
	}

	public IfcAxis2Placement3D getMappingOrigin() {
		return mappingOrigin;
	}

	public void setMappingOrigin(IfcAxis2Placement3D mappingOrigin) {
		this.mappingOrigin = mappingOrigin;
	}

	public Ref getMappedRepresentationRef() {
		return mappedRepresentationRef;
	}

	public void setMappedRepresentationRef(Ref mappedRepresentationRef) {
		this.mappedRepresentationRef = mappedRepresentationRef;
	}

}
