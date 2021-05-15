package nl.infrabim.ifc.dataserver.models;

public class IfcApplication {
	private String type;
	private IfcOrganization applicationDeveloper;
	private String version;
	private String applicationFullName;
	private String applicationIdentifier;

	public IfcApplication() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IfcOrganization getApplicationDeveloper() {
		return applicationDeveloper;
	}

	public void setApplicationDeveloper(IfcOrganization applicationDeveloper) {
		this.applicationDeveloper = applicationDeveloper;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getApplicationFullName() {
		return applicationFullName;
	}

	public void setApplicationFullName(String applicationFullName) {
		this.applicationFullName = applicationFullName;
	}

	public String getApplicationIdentifier() {
		return applicationIdentifier;
	}

	public void setApplicationIdentifier(String applicationIdentifier) {
		this.applicationIdentifier = applicationIdentifier;
	}

}
