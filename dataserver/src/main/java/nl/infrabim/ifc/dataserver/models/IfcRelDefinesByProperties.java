package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelDefinesByProperties extends IfcRoot {
	@Field("relatedObjects")
	private List<Ref> relatedObjectsRef;
	@Field("relatingPropertyDefinition")
	private Ref relatingPropertyDefinitionRef;

	public IfcRelDefinesByProperties() {
		super();
	}

	public List<Ref> getRelatedObjectsRef() {
		return relatedObjectsRef;
	}

	public void setRelatedObjectsRef(List<Ref> relatedObjectsRef) {
		this.relatedObjectsRef = relatedObjectsRef;
	}

	public Ref getRelatingPropertyDefinitionRef() {
		return relatingPropertyDefinitionRef;
	}

	public void setRelatingPropertyDefinitionRef(Ref relatingPropertyDefinitionRef) {
		this.relatingPropertyDefinitionRef = relatingPropertyDefinitionRef;
	}

}
