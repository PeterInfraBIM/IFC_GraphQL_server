package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcSite;

@Repository
public interface IfcSiteRepository extends MongoRepository<IfcSite, String> {

}
