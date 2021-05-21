package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "duplex")
public class IfcRepresentation implements Addressable {
	private String globalId;
	private String type;
	@Field("contextOfItems")
	private Ref contextOfItemsRef;
	private String representationIdentifier;
	private String representationType;
	private List<IfcRepresentationItem> items;

	public IfcRepresentation() {
		super();
	}
	
	@Override
	public String getGlobalId() {
		return globalId;
	}

	@Override
	public String getType() {
		return type;
	}

	public Ref getContextOfItemsRef() {
		return contextOfItemsRef;
	}

	public void setContextOfItemsRef(Ref contextOfItemsRef) {
		this.contextOfItemsRef = contextOfItemsRef;
	}

	public String getRepresentationIdentifier() {
		return representationIdentifier;
	}

	public void setRepresentationIdentifier(String representationIdentifier) {
		this.representationIdentifier = representationIdentifier;
	}

	public String getRepresentationType() {
		return representationType;
	}

	public void setRepresentationType(String representationType) {
		this.representationType = representationType;
	}

	public List<IfcRepresentationItem> getItems() {
		return items;
	}

	public void setItems(List<IfcRepresentationItem> items) {
		this.items = items;
	}

}
