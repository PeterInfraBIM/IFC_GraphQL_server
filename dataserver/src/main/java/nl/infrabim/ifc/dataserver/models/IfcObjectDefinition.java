package nl.infrabim.ifc.dataserver.models;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Ifc_json_2")
public class IfcObjectDefinition extends IfcRoot {
	@Field("isDecomposedBy")
	private List<Ref> isDecomposedByRef;
	@Field("decomposes")
	private List<Ref> decomposesRef;

	public IfcObjectDefinition() {
		super();
	}

	public IfcObjectDefinition(String id, String type, String globalId, String name, String description) {
		super(id, type, globalId, name, description);
	}
	
	public List<Ref> getIsDecomposedByRef() {
		return isDecomposedByRef;
	}

	public void setIsDecomposedByRef(List<Ref> isDecomposedByRef) {
		this.isDecomposedByRef = isDecomposedByRef;
	}

	public List<Ref> getDecomposesRef() {
		return decomposesRef;
	}

	public void setDecomposesRef(List<Ref> decomposesRef) {
		this.decomposesRef = decomposesRef;
	}

}
