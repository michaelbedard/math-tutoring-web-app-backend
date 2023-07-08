package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.QuestionManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionManagerRepository extends JpaRepository<QuestionManager, Long> {

}
