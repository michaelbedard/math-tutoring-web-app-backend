package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.useCases;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLine;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLineFromEquation;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.Solver;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.functions.IsolateFunctions;

import java.util.ArrayList;
import java.util.List;

public class Isolate extends Solver {


    @Override
    public List<SolvedLine> getSolvedLines(List<Variable> variables, Step validStep, Step userStep) {
        List<SolvedLine> solvedLineList = new ArrayList<>();
        if (validStep.getEquation() == userStep.getEquation()) {
            solvedLineList.add(new SolvedLineFromEquation("", "",
                    "You got the right formula! :)"));
        } else {
            solvedLineList.add(new SolvedLineFromEquation("", "",
                    "You got the wrong formula! :("));
        }

        String formula = userStep.getEquation().getFormula();
        String symbolToSolveFor = getMissingSymbol(formula, userStep.getVariablesUseByName());

        solvedLineList.addAll(IsolateFunctions.isolate(formula, symbolToSolveFor));
        return solvedLineList;
    }
}
