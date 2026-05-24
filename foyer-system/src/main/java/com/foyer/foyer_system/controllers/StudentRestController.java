package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.dto.StudentDTO;
import com.foyer.foyer_system.entities.Student;
import com.foyer.foyer_system.responses.ApiResponse;
import com.foyer.foyer_system.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    // ---------------- CREATE ----------------
    @PostMapping
    public ApiResponse<StudentDTO> addStudent(
            @Valid @RequestBody Student student
    ) {
        return new ApiResponse<>(
                "success",
                "Student created successfully",
                studentService.addStudent(student)
        );
    }

    // ---------------- GET ALL ----------------
    @GetMapping
    public ApiResponse<List<StudentDTO>> getAllStudents() {
        return new ApiResponse<>(
                "success",
                "Students retrieved successfully",
                studentService.getAllStudents()
        );
    }

    // ---------------- GET BY ID ----------------
    @GetMapping("/{id}")
    public ApiResponse<StudentDTO> getStudentById(@PathVariable Long id) {
        return new ApiResponse<>(
                "success",
                "Student found",
                studentService.getStudentById(id)
        );
    }

    // ---------------- UPDATE ----------------
    @PutMapping("/{id}")
    public ApiResponse<StudentDTO> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        return new ApiResponse<>(
                "success",
                "Student updated successfully",
                studentService.updateStudent(id, student)
        );
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return new ApiResponse<>(
                "success",
                "Student deleted successfully",
                "deleted"
        );
    }
}