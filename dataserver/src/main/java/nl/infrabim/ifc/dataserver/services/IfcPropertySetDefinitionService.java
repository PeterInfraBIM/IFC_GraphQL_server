package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcPropertySetDefinition;
import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;
import nl.infrabim.ifc.dataserver.models.IfcTypeObject;
import nl.infrabim.ifc.dataserver.models.Ref;

@Service
public class IfcPropertySetDefinitionService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcTypeObjectService typeObjectService;
	@Autowired
	private IfcRelDefinesByPropertiesService relDefinesByPropertiesService;

	public IfcPropertySetDefinition getOnePropertySetDefinition(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcPropertySetDefinition.class);
	}

	public List<IfcTypeObject> getDefinesType(IfcPropertySetDefinition propertySetDefinition) {
		List<IfcTypeObject> definesType = null;
		List<Ref> definesTypeRef = propertySetDefinition.getDefinesTypeRef();
		if (definesTypeRef != null) {
			definesType = new ArrayList<>();
			for (Ref ref : definesTypeRef) {
				definesType.add(typeObjectService.getOneTypeObject(ref.getRef()));
			}
		}
		return definesType;
	}

	public List<IfcRelDefinesByProperties> getPropertyDefinitionOf(IfcPropertySetDefinition propertySetDefinition) {
		List<IfcRelDefinesByProperties> propertyDefinitionOf = null;
		List<Ref> propertyDefinitionOfRef = propertySetDefinition.getPropertyDefinitionOfRef();
		if (propertyDefinitionOfRef != null) {
			propertyDefinitionOf = new ArrayList<>();
			for (Ref ref : propertyDefinitionOfRef) {
				propertyDefinitionOf.add(relDefinesByPropertiesService.getOneRelDefinesByProperties(ref.getRef()));
			}
		}
		return propertyDefinitionOf;
	}
}
