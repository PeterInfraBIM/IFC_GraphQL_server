package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import nl.infrabim.ifc.dataserver.models.IfcRelAssociates;

public interface IfcRelAssociatesRepository extends MongoRepository<IfcRelAssociates, String> {

}
