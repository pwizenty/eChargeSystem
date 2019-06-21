package de.fhdo.echarge.environmentservice.service;

import de.fhdo.echarge.environmentservice.entity.EnvironmentInfo;

import java.util.List;

public interface EnvironmentInfoService {
    EnvironmentInfo createEnvironmentInfo(EnvironmentInfo environmentInfo);

    EnvironmentInfo updateEnvironmentInfo(EnvironmentInfo environmentInfo);

    EnvironmentInfo readEnvironmentInfo(String id);

    Boolean deleteEnvironmentInfo(String id);

    List<EnvironmentInfo> readAllEnvironmentInfos();
}
