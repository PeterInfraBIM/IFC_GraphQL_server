package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcProduct;

@Service
public class IfcProductService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<IfcProduct> getAllProducts() {
		Criteria criteriaV1 = Criteria.where("objectPlacement").exists(true);
		Criteria criteriaV2 = Criteria.where("representation").exists(true);
		Query query = new Query(new Criteria().orOperator(criteriaV1, criteriaV2));
		return mongoTemplate.find(query, IfcProduct.class);
	}

	public IfcProduct getOneProduct(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcProduct.class);
	}

	public List<IfcLocalPlacement> getObjectPlacements(IfcProduct product) {
		List<IfcLocalPlacement> objectPlacements = null;
		IfcLocalPlacement objectPlacement = product.getObjectPlacement();
		while (objectPlacement != null) {
			if (objectPlacements == null) {
				objectPlacements = new ArrayList<>();
			}
			objectPlacements.add(objectPlacement);
			objectPlacement = objectPlacement.getPlacementRelTo();
		}
		return objectPlacements;
	}

}
