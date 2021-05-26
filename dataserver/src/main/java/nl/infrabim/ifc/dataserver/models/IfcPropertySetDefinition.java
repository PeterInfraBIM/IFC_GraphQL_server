package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class IfcPropertySetDefinition extends IfcPropertyDefinition {
	@Field("propertyDefinitionOf")
	private List<Ref> propertyDefinitionOfRef;
	@Field("definesType")
	private List<Ref> definesTypeRef;

	public IfcPropertySetDefinition() {
		super();
	}

	public IfcPropertySetDefinition(String _id, String type, String globalId, String name, String description) {
		super(_id, type, globalId, name, description);
	}

	public List<Ref> getPropertyDefinitionOfRef() {
		return propertyDefinitionOfRef;
	}

	public void setPropertyDefinitionOfRef(List<Ref> propertyDefinitionOfRef) {
		this.propertyDefinitionOfRef = propertyDefinitionOfRef;
	}

	public List<Ref> getDefinesTypeRef() {
		return definesTypeRef;
	}

	public void setDefinesTypeRef(List<Ref> definesTypeRef) {
		this.definesTypeRef = definesTypeRef;
	}

}
