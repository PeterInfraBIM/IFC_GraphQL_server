package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcBooleanValue;
import nl.infrabim.ifc.dataserver.models.IfcIntegerValue;
import nl.infrabim.ifc.dataserver.models.IfcLabel;
import nl.infrabim.ifc.dataserver.models.IfcProperty;
import nl.infrabim.ifc.dataserver.models.IfcPropertySet;
import nl.infrabim.ifc.dataserver.models.IfcPropertySingleValue;
import nl.infrabim.ifc.dataserver.models.IfcRealValue;
import nl.infrabim.ifc.dataserver.models.IfcValue;

@Service
public class IfcPropertySetService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public IfcPropertySet getOnePropertySetDefinition(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcPropertySet.class);
	}

	public List<IfcPropertySet> getAllPropertySets() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcPropertySet"));
		return mongoTemplate.find(query, IfcPropertySet.class);
	}

	public List<IfcProperty> getHasProperties(IfcPropertySet propertySet) {
		List<IfcProperty> castedHasProperties = null;
		List<IfcProperty> hasProperties = propertySet.getHasProperties();
		if (hasProperties != null) {
			castedHasProperties = new ArrayList<>();
			for (IfcProperty property : hasProperties) {
				if (property.getType().equals("IfcPropertySingleValue")) {
					IfcPropertySingleValue propertySingleValue = new IfcPropertySingleValue();
					propertySingleValue.setType(property.getType());
					propertySingleValue.setName(property.getName());
					propertySingleValue.setDescription(property.getDescription());
					propertySingleValue.setNominalValue(property.getNominalValue());
					castedHasProperties.add(propertySingleValue);
				}
			}
		}
		return castedHasProperties;
	}

	public IfcValue getNominalValue(IfcPropertySingleValue propertySingleValue) {
		IfcValue nominalValue = propertySingleValue.getNominalValue();
		if (nominalValue.getType().equals("IfcBoolean")) {
			IfcBooleanValue booleanValue = new IfcBooleanValue();
			booleanValue.setType(nominalValue.getType());
			booleanValue.setValue(nominalValue.getValue());
			booleanValue.setBooleanValue((Boolean) nominalValue.getValue());
			return booleanValue;
		} else if (nominalValue.getType().equals("IfcInteger")) {
			IfcIntegerValue integerValue = new IfcIntegerValue();
			integerValue.setType(nominalValue.getType());
			integerValue.setValue(nominalValue.getValue());
			integerValue.setIntegerValue((Integer) nominalValue.getValue());
			return integerValue;
		} else if (nominalValue.getType().equals("IfcLabel")) {
			IfcLabel label = new IfcLabel();
			label.setType(nominalValue.getType());
			label.setValue(nominalValue.getValue());
			label.setLabelValue((String) nominalValue.getValue());
			return label;
		} else if (nominalValue.getType().equals("IfcReal")) {
			IfcRealValue realValue = new IfcRealValue();
			realValue.setType(nominalValue.getType());
			realValue.setValue(nominalValue.getValue());
			realValue.setRealValue((Double) nominalValue.getValue());
			return realValue;
		}
		return null;
	}

}
