package de.fhdo.echarge.chargingpointservice.repository;


import de.fhdo.echarge.chargingpointservice.entity.ChargingPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargingPointRepository extends CrudRepository<ChargingPoint, String> {

}
