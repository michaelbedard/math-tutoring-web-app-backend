package com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.solvers.functions;

import com.mathtutoringwebapp.mathtutoringwebapp.javaBusinessLogic.getSolution.classes.lines.SolvedLineFromEquation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Operator {
    public static SolvedLineFromEquation exec(String withSymbol, String withoutSymbol, String removedPart, char side) {
        // extract operation and number from removed part
        // call the corresponding function to update withoutSymbol
        // return withSymbol = withoutSymbol, explanation

        String number = extractNumber(removedPart);
        String operator = extractOperator(removedPart);
        SolvedLineFromEquation solvedLine;

        if (operator.equals("+")) {
            withoutSymbol = "(" + withoutSymbol + ")-" + number;
            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
                    "subtract " + number + " on both sides");
        } else if (operator.equals("-")) {
            withoutSymbol = "(" + withoutSymbol + ")+" + number;
            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
                    "add " + number + " on both sides");
        } else if (operator.equals("*")) {
            withoutSymbol = "(" + withoutSymbol + ")/" + number;
            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
                    "divide by " + number + " on both sides");
        }
        else if (operator.equals("/")) {
            withoutSymbol = "(" + withoutSymbol + ")*" + number;
            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
                    "multiply by " + number + " on both sides");
        }
        else if (operator.equals("^") && side == 'R') {
//            withoutSymbol = "(" + withoutSymbol + ")+" + number;
//            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
//                    "add " + number + " on both sides");
        }
        else if (operator.equals("^") && side == 'L') {
            String inverse = "(1/"+ number + ")";
            withoutSymbol = "(" + withoutSymbol + ")^(1/" + inverse + ")";
            solvedLine = new SolvedLineFromEquation(withSymbol, withSymbol,
                    "raise by " + inverse + " on both sides");
        }
        return null;
    }

    private static String extractNumber(String removedPart) {
        String pattern = "(\\d+)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(removedPart);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("no number found inside " + removedPart);
        }
    }

    private static String extractOperator(String removedPart) {
        String pattern = "(\\D)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(removedPart);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("no operator found inside " + removedPart);
        }
    }


}
