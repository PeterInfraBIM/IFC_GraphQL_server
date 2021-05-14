package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import nl.infrabim.ifc.dataserver.models.IfcRelVoidsElement;

public interface IfcRelVoidsElementRepository extends MongoRepository<IfcRelVoidsElement, String> {

}
