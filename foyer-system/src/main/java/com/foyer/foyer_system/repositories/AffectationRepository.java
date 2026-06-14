package com.foyer.foyer_system.repositories;

import com.foyer.foyer_system.entities.Affectation;
import com.foyer.foyer_system.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationRepository extends JpaRepository<Affectation, Long> {

    List<Affectation> findByStudentId(Long studentId);

    List<Affectation> findByStatus(Status status);

    List<Affectation> findByStudentIdAndStatus(Long studentId, Status status);
}
