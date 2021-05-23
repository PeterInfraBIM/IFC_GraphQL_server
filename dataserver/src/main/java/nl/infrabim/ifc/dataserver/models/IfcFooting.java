package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duplex")
public class IfcFooting extends IfcElement {

	public IfcFooting() {
		super();
	}

	public IfcFooting(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}
}
