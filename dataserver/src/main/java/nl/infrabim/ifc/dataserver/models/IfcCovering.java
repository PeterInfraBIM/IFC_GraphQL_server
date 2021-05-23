package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duplex")
public class IfcCovering extends IfcElement {

	public IfcCovering() {
		super();
	}

	public IfcCovering(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}
}
