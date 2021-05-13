package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcRelDefinesByProperties extends IfcRoot {
	@Field("relatingPropertyDefinition")
	private Ref relatingPropertyDefinitionRef;

	public IfcRelDefinesByProperties() {
		super();
	}

	public Ref getRelatingPropertyDefinitionRef() {
		return relatingPropertyDefinitionRef;
	}

	public void setRelatingPropertyDefinitionRef(Ref relatingPropertyDefinitionRef) {
		this.relatingPropertyDefinitionRef = relatingPropertyDefinitionRef;
	}

}
