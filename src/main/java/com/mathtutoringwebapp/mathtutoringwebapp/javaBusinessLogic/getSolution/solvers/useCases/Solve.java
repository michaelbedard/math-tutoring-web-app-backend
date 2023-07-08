package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.useCases;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLine;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.Solver;

import java.util.List;

public class Solve extends Solver {
    @Override
    public List<SolvedLine> getSolvedLines(List<Variable> variables, Step validStep, Step userStep) {
        return null;
    }
}
