package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ifc_json_2")
public class IfcRoot {
	@Id
	private String id;
	private String type;
	private String globalId;
	private String name;
	private String description;

	public IfcRoot() {
	}

	public IfcRoot(String id, String type, String globalId, String name, String description) {
		super();
		this.id = id;
		this.type = type;
		this.globalId = globalId;
		this.name = name;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Root[id='%s', name='%s']", id, name);
	}

	protected void copyRootValues(IfcRoot root) {
		setDescription(root.getDescription());
		setGlobalId(root.getGlobalId());
		setId(root.getId());
		setName(root.getName());
		setType(root.getType());
	}

}
