package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="stars")
@Getter
@Setter
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long starId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int tabKey;

    private boolean starFlag;

    public Star() {

    }

    public Star(User user, int tabKey, boolean starFlag) {
        this.user = user;
        this.tabKey = tabKey;
        this.starFlag = starFlag;
    }

    public boolean isStarFlag() {
        return starFlag;
    }

    public void setStarFlag(boolean starFlag) {
        this.starFlag = starFlag;
    }
}
