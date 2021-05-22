package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcElement extends IfcProduct {
	private String tag;
	@Field("hasAssociations")
	private List<Ref> hasAssociationsRef;
	@Field("hasOpenings")
	private List<Ref> hasOpeningsRef;
	@Field("fillsVoids")
	private List<Ref> fillsVoidsRef;
	@Field("connectedTo")
	private List<Ref> connectedToRef;
	@Field("connectedFrom")
	private List<Ref> connectedFromRef;
	@Field("providesBoundaries")
	private List<Ref> providesBoundariesRef;
	@Field("containedInStructure")
	private List<Ref> containedInStructureRef;

	public IfcElement() {
		super();
	}

	public IfcElement(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Ref> getHasAssociationsRef() {
		return hasAssociationsRef;
	}

	public void setHasAssociationsRef(List<Ref> hasAssociationsRef) {
		this.hasAssociationsRef = hasAssociationsRef;
	}

	public List<Ref> getHasOpeningsRef() {
		return hasOpeningsRef;
	}

	public void setHasOpeningsRef(List<Ref> hasOpeningsRef) {
		this.hasOpeningsRef = hasOpeningsRef;
	}

	public List<Ref> getFillsVoidsRef() {
		return fillsVoidsRef;
	}

	public void setFillsVoidsRef(List<Ref> fillsVoidsRef) {
		this.fillsVoidsRef = fillsVoidsRef;
	}

	public List<Ref> getConnectedToRef() {
		return connectedToRef;
	}

	public void setConnectedToRef(List<Ref> connectedToRef) {
		this.connectedToRef = connectedToRef;
	}

	public List<Ref> getConnectedFromRef() {
		return connectedFromRef;
	}

	public void setConnectedFromRef(List<Ref> connectedFromRef) {
		this.connectedFromRef = connectedFromRef;
	}

	public List<Ref> getProvidesBoundariesRef() {
		return providesBoundariesRef;
	}

	public void setProvidesBoundariesRef(List<Ref> providesBoundariesRef) {
		this.providesBoundariesRef = providesBoundariesRef;
	}

	public List<Ref> getContainedInStructureRef() {
		return containedInStructureRef;
	}

	public void setContainedInStructureRef(List<Ref> containedInStructureRef) {
		this.containedInStructureRef = containedInStructureRef;
	}

}
