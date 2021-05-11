package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IfcExtrudedAreaSolid extends IfcRepresentationItem {

	public IfcExtrudedAreaSolid() {
		super();
	}

	public IfcExtrudedAreaSolid(String type) {
		super(type);
	}

}
