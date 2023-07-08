package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.controllers;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Question;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Variable;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos.PostQuestionDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos.StepDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.QuestionRelatedDtos.VariableDto;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.QuestionMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.StepMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.VariableMapper;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services.QuestionService;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.Main;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.SolvedSolution;
import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.UserSolution;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/question")
public class QuizController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private VariableMapper variableMapper;
    @Autowired
    private StepMapper stepMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("")
    public Question getRandomQuestion() {
        List<Question> questionList = questionService.getAll();

        if (questionList.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(questionList.size());
        return questionList.get(randomIndex);
    }

    @PostMapping("")
    public ResponseEntity<String> createNewQuestion(
            @RequestBody PostQuestionDto postQuestionDto) {

        ResponseEntity<String> response;
        try {
            List<Variable> variableList = new ArrayList<>();
            List<Step> stepList = new ArrayList<>();

            for (VariableDto variableDto : postQuestionDto.getVariableDtos()) {
                variableList.add(variableMapper.toVariable(variableDto));
            }
            for (StepDto stepDto : postQuestionDto.getStepDtos()) {
                if (stepDto.getStepType().equals("EQUATION")) {
                    stepList.add(stepMapper.toEquationStep(stepDto));
                }
            }

            Question newQuestion = questionMapper.toQuestion(postQuestionDto.getQuestionDto());
            newQuestion.setSteps(stepList);
            newQuestion.setVariables(variableList);
            questionService.saveQuestion(newQuestion);

            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Given user details are successfully registered");

        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + e.getMessage());
        }
        return response;
    }

    @PostMapping("/solve/{questionId}/{customVariables}")
    public SolvedSolution solve(
            @PathVariable Long questionId,
            @PathVariable Map<String, Double> customVariables,
            @RequestBody UserSolution userSolution) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Long authenticatedUserId = Long.parseLong(authentication.getName());

        return Main.getSolvedSolution(questionId, customVariables, userSolution);
    }
}
