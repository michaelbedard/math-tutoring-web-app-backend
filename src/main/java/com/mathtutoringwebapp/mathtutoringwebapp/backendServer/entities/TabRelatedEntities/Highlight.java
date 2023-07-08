package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Highlights")
@Getter
@Setter
public class Highlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int tabKey;

    private int startOffset;

    private int endOffset;

    private String style;


    public Highlight() {
    }

    public Highlight(int startOffset, int endOffset, String style) {
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.style = style;
    }
}
