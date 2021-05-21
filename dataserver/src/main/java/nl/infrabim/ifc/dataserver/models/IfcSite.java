package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "duplex")
public class IfcSite extends IfcSpatialStructureElement {
	private List<Double> refLatitude;
	private List<Double> refLongitude;

	public IfcSite() {
		super();
	}

	public List<Double> getRefLatitude() {
		return refLatitude;
	}

	public void setRefLatitude(List<Double> refLatitude) {
		this.refLatitude = refLatitude;
	}

	public List<Double> getRefLongitude() {
		return refLongitude;
	}

	public void setRefLongitude(List<Double> refLongitude) {
		this.refLongitude = refLongitude;
	}

	public IfcSite(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public void copyRootValues(IfcRoot root) {
		super.copyRootValues(root);
	}

}
