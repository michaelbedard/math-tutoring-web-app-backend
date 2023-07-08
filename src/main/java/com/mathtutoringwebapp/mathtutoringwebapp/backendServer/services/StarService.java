package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.services;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Star;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StarService {
    @Autowired
    private StarRepository starRepository;

    public List<Star> getAll(User user){
        return new ArrayList<>(user.getStarSet());
    }

    public void alterStar(int tabKey, boolean hasStar, User user) {
        Optional<Star> optionalStar = starRepository.findByTabKeyAndUser(tabKey, user);
        if (optionalStar.isPresent()) {
            Star star = optionalStar.get();
            if (hasStar) {
                star.setStarFlag(true);
                starRepository.save(star);
            } else {
                starRepository.delete(star);
            }
        } else {
            starRepository.save(new Star(user, tabKey, hasStar));
        }
    }
}
