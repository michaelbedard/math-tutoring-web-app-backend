package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps.Step;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="questions")
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    private String questionText;

    private String image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
    private List<Variable> variables = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<Step> steps = new ArrayList<>();

    public Question() {
    }

    public Question(String questionText, String image, List<Variable> variables, List<Step> steps) {
        this.questionText = questionText;
        this.image = image;
        this.variables = variables;
        this.steps = steps;
    }
}
