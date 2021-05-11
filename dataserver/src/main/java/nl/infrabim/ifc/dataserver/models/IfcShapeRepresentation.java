package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ifc_json_2")
public class IfcShapeRepresentation extends IfcRepresentation {
	private List<IfcProductRepresentation> ofProductRepresentation;

	public IfcShapeRepresentation() {
		super();
	}

	public List<IfcProductRepresentation> getOfProductRepresentation() {
		return ofProductRepresentation;
	}

	public void setOfProductRepresentation(List<IfcProductRepresentation> ofProductRepresentation) {
		this.ofProductRepresentation = ofProductRepresentation;
	}

}
