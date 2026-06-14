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

    private StudentDTO mapToDTO(Student student) {

        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getCin(),
                student.getDateOfBirth()
        );
    }

    @Override
    public StudentDTO addStudent(Student student) {

        Student saved = studentRepository.save(student);

        return mapToDTO(saved);
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapToDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(Long id, Student student) {

        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setCin(student.getCin());
        existing.setDateOfBirth(student.getDateOfBirth());

        Student updated = studentRepository.save(existing);

        return mapToDTO(updated);
    }
    @Override
    public Student getStudentEntityById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}