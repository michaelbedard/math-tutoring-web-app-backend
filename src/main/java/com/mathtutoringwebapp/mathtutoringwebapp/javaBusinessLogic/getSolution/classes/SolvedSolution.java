package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SolvedSolution {
    private List<SolvedStep> solvedSteps;

    public SolvedSolution(List<SolvedStep> solvedSteps) {
        this.solvedSteps = solvedSteps;
    }
}
