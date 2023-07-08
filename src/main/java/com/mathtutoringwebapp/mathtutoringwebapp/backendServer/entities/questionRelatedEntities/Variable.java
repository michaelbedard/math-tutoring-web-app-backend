package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.enums.VariableType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="variables")
@Getter
@Setter
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "variable_id")
    private Long variableId;

    private String name;

    @ManyToOne
    private Unit units;

    private double value;

    private Integer delta;

    @Column(name="type")
    private VariableType type;

    public Variable() {
    }
}
