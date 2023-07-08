package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes;

import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLine;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SolvedStep {
    private List<SolvedLine> solvedLines;

    public SolvedStep(List<SolvedLine> solvedLines) {
        this.solvedLines = solvedLines;
    }
}
