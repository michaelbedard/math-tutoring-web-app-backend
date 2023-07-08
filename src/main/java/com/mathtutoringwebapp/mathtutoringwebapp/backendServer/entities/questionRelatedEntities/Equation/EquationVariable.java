package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Unit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="equation_variables")
@Getter
@Setter
public class EquationVariable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equation_variable_id")
    private Long equationVariableId;

    private int positionIndex;

    @ManyToOne(cascade = CascadeType.ALL)
    private Unit units;

    private String label;

    @ElementCollection
    @CollectionTable(name = "similarIndex", joinColumns = @JoinColumn(name = "equation_variable_id"))
    @Column(name = "similarIndex")
    private List<Integer> similarIndex = new ArrayList<>();

    public EquationVariable(Long equationVariableId, int positionIndex, Unit units, String label, List<Integer> similarIndex) {
        this.equationVariableId = equationVariableId;
        this.positionIndex = positionIndex;
        this.units = units;
        this.label = label;
        this.similarIndex = similarIndex;
    }

    public EquationVariable() {

    }
}
