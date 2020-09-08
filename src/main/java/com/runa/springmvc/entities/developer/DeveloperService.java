package com.runa.springmvc.entities.developer;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeveloperService implements IDeveloperService {

    private final DeveloperRepository developerRepository;

    @Override
    public Page<DeveloperDto> getAllDevelopers(Pageable pageable) {
        Page<Developer> devs = developerRepository.findAll(pageable);
        return devs.map(x -> DeveloperDto.entityToDto(x));
    }

    @Override
    public DeveloperDto getDeveloperById(Long id) {
       Developer dev=developerRepository.getOne(id);
       return DeveloperDto.entityToDto(dev);
    }
}