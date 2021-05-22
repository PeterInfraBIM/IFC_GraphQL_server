package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelContainedInSpatialStructure extends IfcRoot {
	@Field("relatedElements")
	private List<Ref> relatedElementsRef;
	@Field("relatingStructure")
	private Ref relatingStructureRef;

	public IfcRelContainedInSpatialStructure() {
		super();
	}

	public IfcRelContainedInSpatialStructure(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getRelatedElementsRef() {
		return relatedElementsRef;
	}

	public void setRelatedElementsRef(List<Ref> relatedElements) {
		this.relatedElementsRef = relatedElements;
	}

	public Ref getRelatingStructureRef() {
		return relatingStructureRef;
	}

	public void setRelatingStructureRef(Ref relatingStructureRef) {
		this.relatingStructureRef = relatingStructureRef;
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}


}
