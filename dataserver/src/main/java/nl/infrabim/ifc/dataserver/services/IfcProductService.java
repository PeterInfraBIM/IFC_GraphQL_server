package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcLocalPlacement;
import nl.infrabim.ifc.dataserver.models.IfcProduct;
import nl.infrabim.ifc.dataserver.repositories.IfcProductRepository;

@Service
public class IfcProductService {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private IfcProductRepository productRepository;

	public IfcLocalPlacement getObjectPlacement(IfcProduct product) {
		Optional<IfcProduct> findById = productRepository.findById(product.get_Id());
		if (findById.isPresent()) {
			return findById.get().getObjectPlacement();
		}
		return null;
	}

	public List<IfcProduct> getAllProducts() {
		List<IfcProduct> filteredList = null;
		for (IfcProduct candidate : productRepository.findAll()) {
			if (candidate.getObjectPlacement() != null) {
				if (filteredList == null)
					filteredList = new ArrayList<>();
				filteredList.add(candidate);
			}
		}
		return filteredList;
	}

	public IfcProduct getProductByGlobalId(String globalId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("globalId").is(globalId));
		return mongoTemplate.findOne(query, IfcProduct.class);
	}

}
