package de.fhdo.echarge.environmentservice.service.impl;

import de.fhdo.echarge.environmentservice.entity.EnvironmentInfo;
import de.fhdo.echarge.environmentservice.repository.EnvironmentInfoRepository;
import de.fhdo.echarge.environmentservice.service.EnvironmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EnvironmentInfoServiceImpl implements EnvironmentInfoService {
    private EnvironmentInfoRepository environmentInfoRepository;

    @Autowired
    public void setEnvironmentInfoRepository(EnvironmentInfoRepository environmentInfoRepository) {
        this.environmentInfoRepository = environmentInfoRepository;
    }

    @Override
    public EnvironmentInfo createEnvironmentInfo(EnvironmentInfo environmentInfo) {
        return environmentInfoRepository.save(environmentInfo);
    }

    @Override
    public EnvironmentInfo updateEnvironmentInfo(EnvironmentInfo environmentInfo) {
        return environmentInfoRepository.save(environmentInfo);
    }

    @Override
    public EnvironmentInfo readEnvironmentInfo(String id) {
        return environmentInfoRepository.findById(id).orElseGet(null);
    }

    @Override
    public Boolean deleteEnvironmentInfo(String id) {
        if(environmentInfoRepository.existsById(id)) {
            environmentInfoRepository.delete(environmentInfoRepository.findById(id).get());
            return true;
        }
        return false;
    }

    @Override
    public List<EnvironmentInfo> readAllEnvironmentInfos() {
        return StreamSupport.stream(environmentInfoRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
