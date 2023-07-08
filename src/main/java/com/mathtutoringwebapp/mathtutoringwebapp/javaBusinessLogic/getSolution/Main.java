package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Question;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.QuestionService;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.SolvedSolution;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.SolvedStep;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.UserSolution;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLine;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.useCases.Solve;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static final QuestionService questionService = new QuestionService();

    public static SolvedSolution getSolvedSolution(
            Long questionId,
            Map<String, Double> definedVariablesValues,
            UserSolution userSolution) {

        return new Object() {
            List<Variable> definedVariables;
            Question currQuestion;

            SolvedSolution solve() {
                List<SolvedStep> solvedSteps = new ArrayList<>();
                initializeVariables();

                for (int stepIndex = 0 ; stepIndex < currQuestion.getSteps().size() ; stepIndex++) {
                    SolvedStep solvedStep = solveStep(stepIndex);
                    // create new variables from it
                    solvedSteps.add(solvedStep);
                }
                return new SolvedSolution(solvedSteps);
            }

            SolvedStep solveStep(int stepIndex) {  // actually get the solution here
                List<SolvedLine> solvedLines;
                Step step = currQuestion.getSteps().get(stepIndex);
                Step userStep = userSolution.getUserSteps().get(stepIndex);

                String useCase = "dd"; // Step.decodeUseCase(step);
                if (useCase.equals("EVAL")) {
                    Solve evaluateObj = new Solve();
                    solvedLines = evaluateObj.getSolvedLines(definedVariables, step, userStep);

                } else if ((useCase.equals("GRAPH"))) {
                    // do something
                    solvedLines = null;

                } else {
                    throw new RuntimeException("undefined useCase " + useCase);
                }

                return new SolvedStep(solvedLines);
            }

            void initializeVariables() {
                definedVariables = new ArrayList<>();

                Optional<Question> optionalQuestion = questionService.getById(questionId);
                if (optionalQuestion.isPresent()) {
                    currQuestion = optionalQuestion.get();

                    for (Variable variable : currQuestion.getVariables()) {
                        variable.setValue(definedVariablesValues.get(variable.getName()));
                        variable.setDelta(null);
                        definedVariables.add(variable);
                    }
                } else {
                    throw new RuntimeException("question id does not exist");
                }
            }


        }.solve();
    }
}
