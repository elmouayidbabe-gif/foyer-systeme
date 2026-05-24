package com.foyer.foyer_system.repositories;

import com.foyer.foyer_system.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
