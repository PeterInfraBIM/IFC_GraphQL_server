package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcBuilding;

@Repository
public interface IfcBuildingRepository extends MongoRepository<IfcBuilding, String> {

}