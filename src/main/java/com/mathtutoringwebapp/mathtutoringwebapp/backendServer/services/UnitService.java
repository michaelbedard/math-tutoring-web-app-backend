package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Unit;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public Optional<Unit> findById(Long id) {
        return unitRepository.findById(id);
    }
}
