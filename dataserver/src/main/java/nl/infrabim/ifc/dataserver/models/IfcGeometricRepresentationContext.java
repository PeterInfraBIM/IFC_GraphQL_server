package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "duplex")
public class IfcGeometricRepresentationContext implements Addressable {
	private String globalId;
	private String type;
	private String contextType;
	private Integer coordinateSpaceDimension;
	private Double precision;
	private IfcAxis2Placement3D worldCoordinateSystem;
	@Field("representationsInContext")
	private List<Ref> representationsInContextRef;

	public IfcGeometricRepresentationContext() {
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

	public String getContextType() {
		return contextType;
	}

	public void setContextType(String contextType) {
		this.contextType = contextType;
	}

	public Integer getCoordinateSpaceDimension() {
		return coordinateSpaceDimension;
	}

	public void setCoordinateSpaceDimension(Integer coordinateSpaceDimension) {
		this.coordinateSpaceDimension = coordinateSpaceDimension;
	}

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	public IfcAxis2Placement3D getWorldCoordinateSystem() {
		return worldCoordinateSystem;
	}

	public void setWorldCoordinateSystem(IfcAxis2Placement3D worldCoordinateSystem) {
		this.worldCoordinateSystem = worldCoordinateSystem;
	}

	public List<Ref> getRepresentationsInContextRef() {
		return representationsInContextRef;
	}

	public void setRepresentationsInContextRef(List<Ref> representationsInContextRef) {
		this.representationsInContextRef = representationsInContextRef;
	}

}
