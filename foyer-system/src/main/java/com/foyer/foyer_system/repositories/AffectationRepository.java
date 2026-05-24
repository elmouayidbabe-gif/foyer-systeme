package com.foyer.foyer_system.repositories;

import com.foyer.foyer_system.entities.Affectation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {
    List<Affectation> findByStudentId(Long studentId);
}
