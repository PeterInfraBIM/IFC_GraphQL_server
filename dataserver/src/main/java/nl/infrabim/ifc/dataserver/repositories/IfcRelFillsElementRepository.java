package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import nl.infrabim.ifc.dataserver.models.IfcRelFillsElement;

public interface IfcRelFillsElementRepository extends MongoRepository<IfcRelFillsElement, String> {

}
