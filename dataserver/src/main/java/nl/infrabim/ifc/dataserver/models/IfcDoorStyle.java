package nl.infrabim.ifc.dataserver.models;

public class IfcDoorStyle extends IfcTypeProduct {
	private IfcDoorStyleOperationEnum operationType;
	private IfcDoorStyleConstructionEnum constructionType;
	private Boolean parameterTakesPrecedence;
	private Boolean sizeable;

	public IfcDoorStyle() {
		super();
	}

	public IfcDoorStyle(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcDoorStyleOperationEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(IfcDoorStyleOperationEnum operationType) {
		this.operationType = operationType;
	}

	public IfcDoorStyleConstructionEnum getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(IfcDoorStyleConstructionEnum constructionType) {
		this.constructionType = constructionType;
	}

	public Boolean getParameterTakesPrecedence() {
		return parameterTakesPrecedence;
	}

	public void setParameterTakesPrecedence(Boolean parameterTakesPrecedence) {
		this.parameterTakesPrecedence = parameterTakesPrecedence;
	}

	public Boolean getSizeable() {
		return sizeable;
	}

	public void setSizeable(Boolean sizeable) {
		this.sizeable = sizeable;
	}

}
