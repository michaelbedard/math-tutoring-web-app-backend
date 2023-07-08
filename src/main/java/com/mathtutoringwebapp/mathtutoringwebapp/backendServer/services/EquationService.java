package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.Equation;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.EquationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquationService {
    @Autowired
    private EquationRepository equationRepository;

    public List<Equation> getAll() {
        return equationRepository.findAll();
    }

    @Transactional
    public Equation saveEquation(Equation equation) {
        return equationRepository.save(equation);
    }
}
