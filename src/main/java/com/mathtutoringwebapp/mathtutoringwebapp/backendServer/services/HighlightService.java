package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Highlight;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.HighlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class HighlightService {
    @Autowired
    private HighlightRepository highlightRepository;

    public void saveHighlight(Highlight highlight, int tabKey, User user) {
        highlight.setUser(user);
        highlight.setTabKey(tabKey);
        highlightRepository.save(highlight);
    }

    public void deleteHighlight(Highlight highlight) {
        highlightRepository.delete(highlight);
    }

    public List<Highlight> getHighlightsFromTabKey(int tabKey, User user) {
        return highlightRepository.findByTabKeyAndUser(tabKey, user);
    }

}
