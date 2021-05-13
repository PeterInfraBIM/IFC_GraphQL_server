package nl.infrabim.ifc.dataserver.models;

import java.util.List;

public class IfcPropertySet extends IfcRoot {
	private List<IfcProperty> hasProperties;

	public IfcPropertySet() {
		super();
	}

	public IfcPropertySet(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public List<IfcProperty> getHasProperties() {
		return hasProperties;
	}

	public void setHasProperties(List<IfcProperty> hasProperties) {
		this.hasProperties = hasProperties;
	}

}
