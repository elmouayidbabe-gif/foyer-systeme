package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.StudentDTO;
import com.foyer.foyer_system.entities.Student;
import com.foyer.foyer_system.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // ---------------- MAPPER ----------------
    private StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName()
        );
    }

    // ---------------- ADD ----------------
    @Override
    public StudentDTO addStudent(Student student) {
        Student saved = studentRepository.save(student);
        return mapToDTO(saved);
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------------- GET BY ID ----------------
    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapToDTO(student);
    }

    // ---------------- DELETE ----------------
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // ---------------- UPDATE ----------------
    @Override
    public StudentDTO updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setFirstName(student.getFirstName());
        existing.setFirstName(student.getLastName());

        Student updated = studentRepository.save(existing);

        return mapToDTO(updated);
    }
}