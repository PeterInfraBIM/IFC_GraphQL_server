package nl.infrabim.ifc.dataserver.resolvers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import nl.infrabim.ifc.dataserver.models.IfcObject;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.Ref;
import nl.infrabim.ifc.dataserver.services.IfcObjectService;
import nl.infrabim.ifc.dataserver.services.IfcPropertySetService;

@Component
public class IfcRelDefinesByPropertiesResolver implements GraphQLResolver<IfcRelDefinesByProperties> {
	@Autowired
	private IfcPropertySetService propertySetService;
	@Autowired
	private IfcObjectService objectService;

	public IfcPropertySet getRelatingPropertyDefinition(IfcRelDefinesByProperties relDefinesByProperties) {
		Ref relatingPropertyDefinitionRef = relDefinesByProperties.getRelatingPropertyDefinitionRef();
		if (relatingPropertyDefinitionRef != null) {
			return propertySetService.getPropertySetDefinitionByGlobalId(relatingPropertyDefinitionRef.getRef());
		}
		return null;
	}

	public List<IfcObject> getRelatedObjects(IfcRelDefinesByProperties relDefinesByProperties) {
		List<IfcObject> relatedObjects = null;
		List<Ref> relatedObjectsRef = relDefinesByProperties.getRelatedObjectsRef();
		if (relatedObjectsRef != null) {
			relatedObjects = new ArrayList<>();
			for (Ref relatedObject : relatedObjectsRef) {
				relatedObjects.add(objectService.getObjectByGlobalId(relatedObject.getRef()));
			}
		}
		return relatedObjects;
	}
}
