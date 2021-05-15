package nl.infrabim.ifc.dataserver.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ifc_json_2")
public class IfcOwnerHistory implements Addressable {
	private String globalId;
	private String type;
	private IfcPersonAndOrganization owningUser;
	private IfcApplication owningApplication;
	private IfcChangeActionEnum changeAction;
	private Integer creationDate;

	public IfcOwnerHistory() {
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

	public IfcPersonAndOrganization getOwningUser() {
		return owningUser;
	}

	public void setOwningUser(IfcPersonAndOrganization owningUser) {
		this.owningUser = owningUser;
	}

	public IfcApplication getOwningApplication() {
		return owningApplication;
	}

	public void setOwningApplication(IfcApplication owningApplication) {
		this.owningApplication = owningApplication;
	}

	public IfcChangeActionEnum getChangeAction() {
		return changeAction;
	}

	public void setChangeAction(IfcChangeActionEnum changeAction) {
		this.changeAction = changeAction;
	}

	public Integer getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Integer creationDate) {
		this.creationDate = creationDate;
	}

}
