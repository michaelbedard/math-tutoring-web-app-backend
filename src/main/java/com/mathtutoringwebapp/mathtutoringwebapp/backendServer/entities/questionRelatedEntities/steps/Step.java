package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation.Equation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "steps", indexes = {@Index(name = "step_id_index", columnList = "step_id")})
@Getter
@Setter
public abstract class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "step_id")
    private Long stepId;

    // Common fields or methods for all steps
    @ManyToOne
    private Equation equation;

    private String useCase;

    @ElementCollection // 1
    @CollectionTable(name = "variables_use_by_name", joinColumns = @JoinColumn(name = "step_id")) // 2
    @Column(name = "var_used") // 3
    private List<String> variablesUseByName;
}
