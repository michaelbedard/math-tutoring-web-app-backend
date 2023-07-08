//package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name="tabs")
//@Getter
//@Setter
//public class Tab {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private int tabKey;
//
//    private boolean star;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tab_id")
//    private List<Highlight> highlights = new ArrayList<>();
//
//    public boolean isEmpty() {
//        return !star && highlights.isEmpty();
//    }
//
//    public Tab() {
//    }
//
//    public Tab(int tabKey, boolean star, List<Highlight> highlights) {
//        this.tabKey = tabKey;
//        this.star = star;
//        this.highlights = highlights;
//    }
//}
