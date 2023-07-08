package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="question_managers")
@Getter
@Setter
public class QuestionManager {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "question_manager_set1", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "failed")
    private Set<Integer> failedQuestionIds = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "question_manager_set2", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "succeed")
    private Set<Integer> succeedQuestionIds = new HashSet<>();

    @OneToOne(mappedBy = "questionManager")
    private User user;

    public QuestionManager() {

    }
}
