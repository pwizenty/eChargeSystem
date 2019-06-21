package de.fhdo.echarge.chargingpointservice.service;


import de.fhdo.echarge.chargingpointservice.entity.ChargingPoint;

import java.util.List;

public interface ChargingPointService {
    ChargingPoint createChargingPoint(ChargingPoint chargingPoint);

    ChargingPoint readChargingPoint(String id);

    ChargingPoint updateChargingPoint(ChargingPoint chargingPoint);

    boolean deleteChargingPoint(String id);

    List<ChargingPoint> readAllChargingPoints();
}
