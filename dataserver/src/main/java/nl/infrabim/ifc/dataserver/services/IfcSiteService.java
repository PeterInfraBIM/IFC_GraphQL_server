package nl.infrabim.ifc.dataserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import nl.infrabim.ifc.dataserver.models.IfcRoot;
import nl.infrabim.ifc.dataserver.models.IfcShapeRepresentation;
import nl.infrabim.ifc.dataserver.models.IfcSite;
import nl.infrabim.ifc.dataserver.repositories.IfcSiteRepository;

@Service
public class IfcSiteService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private IfcSiteRepository siteRepository;

	public List<IfcSite> getAllSites() {
		Query query = new Query();
		query.addCriteria(Criteria.where("type").is("IfcSite"));
		return mongoTemplate.find(query, IfcSite.class);
	}

//	public List<Double> getRefLatitude(IfcSite site) {
//		Optional<IfcSite> findById = siteRepository.findById(site.get_Id());
//		if (findById.isPresent()) {
//			return findById.get().getRefLatitude();
//		}
//		return null;
//	}
//
//	public List<Double> getRefLongitude(IfcSite site) {
//		Optional<IfcSite> findById = siteRepository.findById(site.get_Id());
//		if (findById.isPresent()) {
//			return findById.get().getRefLongitude();
//		}
//		return null;
//	}

}
