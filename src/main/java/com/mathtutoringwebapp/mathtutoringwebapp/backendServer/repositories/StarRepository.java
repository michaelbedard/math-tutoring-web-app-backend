package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories;


import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.TabRelatedEntities.Star;
import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    Optional<Star> findByTabKeyAndUser(int tabKey, User user);
}
