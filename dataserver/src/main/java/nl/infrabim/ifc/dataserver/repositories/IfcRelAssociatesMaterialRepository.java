package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import nl.infrabim.ifc.dataserver.models.IfcRelAssociatesMaterial;

public interface IfcRelAssociatesMaterialRepository extends MongoRepository<IfcRelAssociatesMaterial, String> {

}
