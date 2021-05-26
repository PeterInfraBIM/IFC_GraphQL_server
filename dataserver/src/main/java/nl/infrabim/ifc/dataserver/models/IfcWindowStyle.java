package nl.infrabim.ifc.dataserver.models;

public class IfcWindowStyle extends IfcTypeProduct {
	private IfcWindowStyleOperationEnum operationType;
	private IfcWindowStyleConstructionEnum constructionType;
	private Boolean parameterTakesPrecedence;
	private Boolean sizeable;

	public IfcWindowStyle() {
		super();
	}

	public IfcWindowStyle(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}

	public IfcWindowStyleOperationEnum getOperationType() {
		return operationType;
	}

	public void setOperationType(IfcWindowStyleOperationEnum operationType) {
		this.operationType = operationType;
	}

	public IfcWindowStyleConstructionEnum getConstructionType() {
		return constructionType;
	}

	public void setConstructionType(IfcWindowStyleConstructionEnum constructionType) {
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
