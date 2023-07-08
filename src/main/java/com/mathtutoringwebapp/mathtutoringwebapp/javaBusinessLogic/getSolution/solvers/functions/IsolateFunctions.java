package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.functions;


import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLineFromEquation;

import java.util.ArrayList;
import java.util.List;

public abstract class IsolateFunctions {

    public static List<SolvedLineFromEquation> isolate(final String equation, final String symbol) {
        return new Object() {
            List<SolvedLineFromEquation> solvedLines;
            int rightPos, prevRightPos, rightLevel, leftPos, prevLeftPos, leftLevel;
            String withSymbol;
            String withoutSymbol;

            List<SolvedLineFromEquation> exec() {
                initialize();
                while (!withSymbol.equals(symbol)) {
                    prevRightPos = rightPos; prevLeftPos = leftLevel;
                    while (rightLevel < 0) {
                        rightLevel = updateLevel(withSymbol.charAt(rightPos), 'R');
                        rightPos ++;
                    }
                    while (leftLevel < 0) {
                        leftLevel = updateLevel(withSymbol.charAt(leftPos), 'L');
                        leftPos --;
                    }
                    if (rightLevel > leftLevel) {
                        rightPos = prevRightPos; // reset cursor
                        solvedLines.add(Operator.exec(
                                withSymbol.substring(rightPos, leftPos), // new withSymbol
                                withoutSymbol, // old withoutSymbol
                                withSymbol.substring(leftPos, prevLeftPos), // extracted part from withSymbol
                                'L'
                        ));
                    } else if (rightLevel < leftLevel) {
                        leftPos = prevLeftPos;
                        solvedLines.add(Operator.exec(
                                withSymbol.substring(rightPos, leftPos),
                                withoutSymbol,
                                withSymbol.substring(prevRightPos, rightPos),
                                'R'
                        ));
                    } else {
                        String combinedResult =
                                withSymbol.substring(prevRightPos, rightPos) + withSymbol.substring(leftPos, prevLeftPos);

                        solvedLines.add(Operator.exec(
                                withSymbol.substring(rightPos, leftPos),
                                withoutSymbol,
                                combinedResult,
                                'B'
                        ));
                    }
                }
                return solvedLines;
            }

            int updateLevel(char c, char side) {
                int newLevel = - 1;
                if (c == '+' || c == '-') {
                    newLevel = 0;
                } else if (c == '*' || c == '/') {
                    newLevel = 1;
                } else if (c == '^') {
                    newLevel = 2;
                } else if (c == '(' || c == ')') {
                    newLevel = 3;
                }
                if (newLevel < 0) {
                    return side == 'L' ? leftLevel : rightLevel; //do not change
                } else {
                    return newLevel;
                }
            }

            void initialize() {
                String[] expressions = equation.replaceAll(" ", "").split("=");
                if (IsolateFunctions.containsSymbol(expressions[0], symbol)) {
                    withSymbol = expressions[0];
                    withoutSymbol = expressions[1];
                } else {
                    withSymbol = expressions[1];
                    withoutSymbol = expressions[0];
                }
                solvedLines = new ArrayList<>();
                rightPos = 0; leftPos = withSymbol.length() - 1;
                resetLevel();
            }
            void resetLevel() {
                rightLevel = -1;leftLevel = -1;
            }

        }.exec();
    }

    private static boolean containsSymbol(String equation, String symbol) {
        int length = equation.length();
        int symbolLength = symbol.length();
        for (int i = 0; i <= length - symbolLength; i++) {
            if (equation.substring(i, i + symbolLength).equals(symbol)) {
                // Check if the symbol is surrounded by non-letters
                boolean surroundedByNonLetters = true;
                if (i > 0 && Character.isLetter(equation.charAt(i - 1))) {
                    surroundedByNonLetters = false;
                }
                if (i + symbolLength < length && Character.isLetter(equation.charAt(i + symbolLength))) {
                    surroundedByNonLetters = false;
                }
                if (surroundedByNonLetters) {
                    return true;
                }
            }
        }
        return false;

    }
}
