package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.steps;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapping;

@Entity
@Getter
@Setter
public class EquationStep extends Step {

    private String variableCreatedByName;

    public EquationStep () {

    }
}
