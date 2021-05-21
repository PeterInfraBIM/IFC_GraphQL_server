package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "duplex")
public class IfcRoot {
	@Id
	private String _id;
	private String type;
	private String globalId;
	private String name;
	private String description;
	@Field("ownerHistory")
	private Ref ownerHistoryRef;

	public IfcRoot() {
	}

	public IfcRoot(String _id, String type, String globalId, String name, String description) {
		super();
		this._id = _id;
		this.type = type;
		this.globalId = globalId;
		this.name = name;
		this.description = description;
	}

	public String get_Id() {
		return _id;
	}

	public void set_Id(String _id) {
		this._id = _id;
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
		return String.format("Root[id='%s', name='%s']", _id, name);
	}

	public Ref getOwnerHistoryRef() {
		return ownerHistoryRef;
	}

	public void setOwnerHistoryRef(Ref ownerHistoryRef) {
		this.ownerHistoryRef = ownerHistoryRef;
	}

	protected void copyRootValues(IfcRoot root) {
		setDescription(root.getDescription());
		setGlobalId(root.getGlobalId());
		set_Id(root.get_Id());
		setName(root.getName());
		setType(root.getType());
	}

}
