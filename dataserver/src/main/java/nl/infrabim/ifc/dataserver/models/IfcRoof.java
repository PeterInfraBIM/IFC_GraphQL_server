package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duplex")
public class IfcRoof extends IfcElement {
	private IfcRoofTypeEnum shapeType;

	public IfcRoof() {
		super();
	}

	public IfcRoof(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}

	public IfcRoofTypeEnum getShapeType() {
		return shapeType;
	}

	public void setShapeType(IfcRoofTypeEnum shapeType) {
		this.shapeType = shapeType;
	}
}
