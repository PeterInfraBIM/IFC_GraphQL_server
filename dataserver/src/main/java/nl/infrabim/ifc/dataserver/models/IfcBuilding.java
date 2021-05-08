package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ifc_json_2")
public class IfcBuilding extends IfcSpatialStructureElement {

	public IfcBuilding() {
		super();
	}

	public IfcBuilding(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}

}
