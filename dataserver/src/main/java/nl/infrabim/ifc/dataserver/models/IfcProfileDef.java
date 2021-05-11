package nl.infrabim.ifc.dataserver.models;

public class IfcProfileDef {
	private IfcProfileTypeEnum profileType;
	private String type;
	private IfcPolyline outerCurve;

	public IfcProfileDef() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IfcProfileTypeEnum getProfileType() {
		return profileType;
	}

	public void setProfileType(IfcProfileTypeEnum profileType) {
		this.profileType = profileType;
	}

	public IfcPolyline getOuterCurve() {
		return outerCurve;
	}

	public void setOuterCurve(IfcPolyline outerCurve) {
		this.outerCurve = outerCurve;
	}
}
