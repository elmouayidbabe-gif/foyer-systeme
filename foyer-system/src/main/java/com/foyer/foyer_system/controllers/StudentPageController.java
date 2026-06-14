package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.entities.Student;
import com.foyer.foyer_system.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class StudentPageController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student) {

        if (student.getId() == null) {
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student.getId(), student);
        }

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {

        Student student = studentService.getStudentEntityById(id);

        model.addAttribute("student", student);
        model.addAttribute("students", studentService.getAllStudents());

        return "students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}