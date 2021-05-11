package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcPolyline;

@Repository
public interface IfcPolylineRepository extends MongoRepository<IfcPolyline, String> {

}
