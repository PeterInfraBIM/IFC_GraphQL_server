package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duplex")
public class IfcRailing extends IfcElement {
	private IfcRailingTypeEnum 	predefinedType;

	public IfcRailing() {
		super();
	}

	public IfcRailing(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}

	public IfcRailingTypeEnum getPredefinedType() {
		return predefinedType;
	}

	public void setPredefinedType(IfcRailingTypeEnum predefinedType) {
		this.predefinedType = predefinedType;
	}
	
}
