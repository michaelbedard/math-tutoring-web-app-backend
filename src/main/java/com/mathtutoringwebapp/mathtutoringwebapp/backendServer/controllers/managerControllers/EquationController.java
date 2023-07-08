package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.controllers.managerControllers;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.Equation;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.EquationVariable;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Unit;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.EquationService;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.UnitService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equation")
public class EquationController {
    @Autowired
    private EquationService equationService;
    @Autowired
    private UnitService unitService;

    @GetMapping("")
    public ResponseEntity<Iterable<Equation>> getAllEquation() {
        List<Equation> equationList = equationService.getAll();
        return ResponseEntity.ok(equationList);
    }

    @PostMapping("")
    public ResponseEntity<Equation> createNewEquation(@RequestBody Equation equation) {
        for (EquationVariable equationVariable : equation.getVariables()) {
            Optional<Unit> optionalUnit = unitService.findById(equationVariable.getUnits().getUnitId());
            if (optionalUnit.isPresent()) {
                equationVariable.setUnits(optionalUnit.get());
            } else {
                new EntityNotFoundException("Unit not found");
            }
        }
        Equation savedEquation = equationService.saveEquation(equation);
        return ResponseEntity.ok(savedEquation);
    }
}
