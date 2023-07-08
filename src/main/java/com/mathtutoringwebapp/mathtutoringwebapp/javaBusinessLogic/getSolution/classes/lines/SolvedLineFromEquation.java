package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SolvedLineFromEquation implements SolvedLine {
    private String leftSide;
    private String rightSide;
    private String lineExplanation;

    public SolvedLineFromEquation(String leftSide, String rightSide, String lineExplanation) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        this.lineExplanation = lineExplanation;
    }
}
