package com.mathtutoringwebapp.mathtutoringwebapp.backendServer.repositories;

import com.mathtutoringwebapp.mathtutoringwebapp.backendServer.entities.questionRelatedEntities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
