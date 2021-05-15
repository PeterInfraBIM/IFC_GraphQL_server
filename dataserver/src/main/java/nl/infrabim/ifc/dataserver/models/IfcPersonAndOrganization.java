package nl.infrabim.ifc.dataserver.models;

public class IfcPersonAndOrganization {
	private String type;
	private IfcPerson thePerson;
	private IfcOrganization theOrganization;

	public IfcPersonAndOrganization() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IfcPerson getThePerson() {
		return thePerson;
	}

	public void setThePerson(IfcPerson thePerson) {
		this.thePerson = thePerson;
	}

	public IfcOrganization getTheOrganization() {
		return theOrganization;
	}

	public void setTheOrganization(IfcOrganization theOrganization) {
		this.theOrganization = theOrganization;
	}

}
