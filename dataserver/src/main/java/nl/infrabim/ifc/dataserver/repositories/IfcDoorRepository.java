package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcDoor;

@Repository
public interface IfcDoorRepository extends MongoRepository<IfcDoor, String> {

}
