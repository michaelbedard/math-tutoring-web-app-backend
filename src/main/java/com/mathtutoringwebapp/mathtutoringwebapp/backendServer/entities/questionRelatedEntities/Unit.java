package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="units")
@Getter
@Setter
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unit_id")
    private Long unitId;

    private String symbol;

    public Unit() {

    }

    public Unit(Long unitId, String symbol) {
        this.unitId = unitId;
        this.symbol = symbol;
    }
}
