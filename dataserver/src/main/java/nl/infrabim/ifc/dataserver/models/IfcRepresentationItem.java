package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IfcRepresentationItem {
	private String type;
	private List<IfcCartesianPoint> points;
	private IfcDirection extrudedDirection;
	private Double depth;
	private IfcAxis2Placement3D position;
	private IfcArbitraryClosedProfileDef sweptArea;

	public IfcRepresentationItem() {
		super();
	}

	public IfcRepresentationItem(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<IfcCartesianPoint> getPoints() {
		return points;
	}

	public void setPoints(List<IfcCartesianPoint> points) {
		this.points = points;
	}

	public IfcDirection getExtrudedDirection() {
		return extrudedDirection;
	}

	public void setExtrudedDirection(IfcDirection extrudedDirection) {
		this.extrudedDirection = extrudedDirection;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	public IfcAxis2Placement3D getPosition() {
		return position;
	}

	public void setPosition(IfcAxis2Placement3D position) {
		this.position = position;
	}

	public IfcArbitraryClosedProfileDef getSweptArea() {
		return sweptArea;
	}

	public void setSweptArea(IfcArbitraryClosedProfileDef sweptArea) {
		this.sweptArea = sweptArea;
	}

}
