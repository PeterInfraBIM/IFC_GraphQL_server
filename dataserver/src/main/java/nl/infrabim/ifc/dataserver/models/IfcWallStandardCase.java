package nl.infrabim.ifc.dataserver.models;

public class IfcWallStandardCase extends IfcElement {

	public IfcWallStandardCase() {
		super();
	}

	public IfcWallStandardCase(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}
	
	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}
}
