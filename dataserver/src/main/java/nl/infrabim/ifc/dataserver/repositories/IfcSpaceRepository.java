package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcSpace;

@Repository
public interface IfcSpaceRepository extends MongoRepository<IfcSpace, String> {

}
