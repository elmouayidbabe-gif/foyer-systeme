package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.StudentDTO;
import com.foyer.foyer_system.entities.Student;

import java.util.List;

public interface StudentService {

    StudentDTO addStudent(Student student);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    void deleteStudent(Long id);

    StudentDTO updateStudent(Long id, Student student);
}