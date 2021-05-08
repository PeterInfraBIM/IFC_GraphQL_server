package nl.infrabim.ifc.dataserver.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import nl.infrabim.ifc.dataserver.models.IfcRelContainedInSpatialStructure;

@Repository
public interface IfcRelContainedInSpatialStructureRepository
		extends MongoRepository<IfcRelContainedInSpatialStructure, String> {

}
