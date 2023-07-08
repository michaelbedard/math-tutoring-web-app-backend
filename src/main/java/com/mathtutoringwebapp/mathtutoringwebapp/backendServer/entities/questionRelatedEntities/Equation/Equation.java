package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Equation;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="equations")
@Getter
@Setter
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equation_id")
    private Long equationId;

    private String name;

    private String formula;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="equation_id")
    private List<EquationVariable> variables = new ArrayList<>();


    public Equation() {
    }

    public static List<String> getLetters(String formula) {
        List<String> letters = new ArrayList<>();

        Pattern regex = Pattern.compile("(?<![a-zA-Z])[a-zA-Z](?![a-zA-Z])");
        Matcher matcher = regex.matcher(formula);

        while (matcher.find()) {
            if (!letters.contains(matcher.group())) {
                letters.add(matcher.group());
            }
        }
        return letters;
    }
}
