package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Question;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> getById(Long id) {
        return questionRepository.findById(id);
    }

}
