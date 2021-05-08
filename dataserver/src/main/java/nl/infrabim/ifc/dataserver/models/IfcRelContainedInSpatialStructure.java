package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcRelContainedInSpatialStructure extends IfcRoot {
	private List<Ref> relatedElements;
	private Ref relatingStructure;

	public IfcRelContainedInSpatialStructure() {
		super();
	}

	public IfcRelContainedInSpatialStructure(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<Ref> getRelatedElements() {
		return relatedElements;
	}

	public void setRelatedElements(List<Ref> relatedElements) {
		this.relatedElements = relatedElements;
	}

	public Ref getRelatingStructure() {
		return relatingStructure;
	}

	public void setRelatingStructure(Ref relatingStructure) {
		this.relatingStructure = relatingStructure;
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}


}
