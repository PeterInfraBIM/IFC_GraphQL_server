package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcObjectDefinition;
import nl.infrabim.ifc.dataserver.models.IfcPolyline;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.models.IfcRepresentationItem;
import nl.infrabim.ifc.dataserver.models.IfcShapeRepresentation;
import nl.infrabim.ifc.dataserver.repositories.IfcPolylineRepository;
import nl.infrabim.ifc.dataserver.repositories.IfcProductRepository;
import nl.infrabim.ifc.dataserver.repositories.IfcShapeRepresentationRepository;

@Service
public class IfcShapeRepresentationService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcShapeRepresentationRepository shapeRepresentationRepository;
	@Autowired
	private MongoClient mongoClient;

	public List<IfcShapeRepresentation> getAllShapeRepresentations() {
		List<IfcShapeRepresentation> filteredList = null;
		for (IfcShapeRepresentation candidate : shapeRepresentationRepository.findAll()) {
			if (candidate.getType().equals("IfcShapeRepresentation")) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public IfcShapeRepresentation getShapeRepresentationByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcShapeRepresentation.class);
	}

}
