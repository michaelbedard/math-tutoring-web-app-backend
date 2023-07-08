//package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;
//
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Tab;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.HighlightDto;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.HighlightMapper;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.mappersAndDtos.mappers.UserMapper;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.HighlightRepository;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.TabRepository;
//import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.swing.text.StyledEditorKit;
//import java.util.*;
//
//@Service
//public class TabService {
//    @Autowired
//    private TabRepository tabRepository;
//    @Autowired
//    private HighlightRepository highlightRepository;
//    @Autowired
//    private HighlightMapper highlightMapper;
//
//    public void deleteTab(Tab tab) {
//        tabRepository.delete(tab);
//    }
//
//    public void deleteHighlight(Highlight highlight) {
//        highlightRepository.delete(highlight);
//    }
//
//    public Optional<Tab> getTabByUserAndKey(User user, int key) {
//        for (Tab tab : user.getPersonalizedTabs()) {
//            if (tab.getTabKey() == key) {
//                return Optional.of(tab);
//            }
//        }
//        return Optional.empty();
//    }
//
//    public Iterable<HighlightDto> getAllTabHighlightDtos(Tab tab) {
//        Set<HighlightDto> temp = new HashSet<>();
//        for (Highlight highlight : tab.getHighlights()) {
//            temp.add(highlightMapper.toHighlightDto(highlight));
//        }
//        return temp;
//    }
//
//    public boolean getStar(User user, int level, int tabKey) {
//        for (Tab tab : user.getPersonalizedTabs()) {
//            if (level <= tab.getTabKey() && tab.getTabKey() < level + 100
//                    && tab.getTabKey() == tabKey) {
//                return tab.isStar();
//            }
//        }
//        return false;
//    }
//
//
//}
