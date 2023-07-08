package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Star;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.QuestionManager;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Authority> authorities;

    @Column(name="createDt")
    private String createDt;

    @OneToOne(fetch = FetchType.LAZY)
    private QuestionManager questionManager;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Highlight> highlightSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Star> starSet = new HashSet<>();
}
