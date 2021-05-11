package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IfcPolyline extends IfcRepresentationItem {
	public IfcPolyline() {
		super();
	}

	public IfcPolyline(String type) {
		super(type);
	}



}
