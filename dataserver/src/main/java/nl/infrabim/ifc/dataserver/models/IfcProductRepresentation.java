package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class IfcProductRepresentation {
	@Field("representations")
	List<Ref> representationsRef;

	public IfcProductRepresentation() {
		super();
	}

	public List<Ref> getRepresentationsRef() {
		return representationsRef;
	}

	public void setRepresentationsRef(List<Ref> representationsRef) {
		this.representationsRef = representationsRef;
	}

}
