package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import nl.infrabim.ifc.dataserver.models.IfcRelDefinesByProperties;

public interface IfcRelDefinesByPropertiesRepository extends MongoRepository<IfcRelDefinesByProperties, String> {

}
