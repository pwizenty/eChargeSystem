package de.fhdo.echarge.chargingpointservice.service.impl;


import de.fhdo.echarge.chargingpointservice.entity.ChargingPoint;
import de.fhdo.echarge.chargingpointservice.repository.ChargingPointRepository;
import de.fhdo.echarge.chargingpointservice.service.ChargingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChargingPointServiceImpl implements ChargingPointService {
    private ChargingPointRepository chargingPointRepository;

    @Autowired
    public void setChargingPointRepository(ChargingPointRepository chargingPointRepository) {
        this.chargingPointRepository = chargingPointRepository;
    }

    @Override
    public ChargingPoint createChargingPoint(ChargingPoint chargingPoint) {
        return chargingPointRepository.save(chargingPoint);
    }

    @Override
    public ChargingPoint readChargingPoint(String id) {
        return chargingPointRepository.findById(id).orElseGet(null);
    }

    @Override
    public ChargingPoint updateChargingPoint(ChargingPoint chargingPoint) {
        return chargingPointRepository.save(chargingPoint);
    }

    @Override
    public boolean deleteChargingPoint(String id) {
        if (chargingPointRepository.existsById(id)) {
            chargingPointRepository.delete(chargingPointRepository.findById(id).orElseGet(null));
            return true;
        }
        return false;
    }

    @Override
    public List<ChargingPoint> readAllChargingPoints() {
        return StreamSupport.stream(chargingPointRepository.findAll().spliterator(),
                false).collect(Collectors.toList());
    }
}
