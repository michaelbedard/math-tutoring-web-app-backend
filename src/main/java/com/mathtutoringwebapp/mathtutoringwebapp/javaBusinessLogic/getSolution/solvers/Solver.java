package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.Equation;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLine;

import java.util.List;

public abstract class Solver {
    protected abstract List<SolvedLine> getSolvedLines(List<Variable> variables, Step validStep, Step userStep);

    public String getMissingSymbol(String formula, List<String> variablesUseBySymbol) {
        List<String> lettersInEquation = Equation.getLetters(formula);

        if (lettersInEquation.size() == variablesUseBySymbol.size()) {
            for (int i = 0 ; i < lettersInEquation.size() ; i++) {
                if (variablesUseBySymbol.get(i) == null) {
                    return lettersInEquation.get(i);
                }
            }
            throw new RuntimeException("no variable in variablesUseBySymbol is null (it should have one)");
        } else {
            throw new RuntimeException("number of variable in " + formula + " and in variablesUseBySymbol are not the same");
        }
    }
}
