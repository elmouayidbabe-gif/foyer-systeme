package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.services.AffectationService;
import com.foyer.foyer_system.services.RoomService;
import com.foyer.foyer_system.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AffectationPageController {

    private final AffectationService affectationService;
    private final StudentService studentService;
    private final RoomService roomService;

    @GetMapping("/affectations")
    public String affectations(Model model) {

        model.addAttribute("affectations", affectationService.getAllAffectations());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("affectation", new AffectationDTO());

        return "affectations";
    }

    @PostMapping("/affectations/save")
    public String save(@ModelAttribute AffectationDTO dto) {
        affectationService.addAffectation(dto);
        return "redirect:/affectations";
    }

    @GetMapping("/affectations/delete/{id}")
    public String delete(@PathVariable Long id) {
        affectationService.deleteAffectation(id);
        return "redirect:/affectations";
    }

    @GetMapping("/affectations/approve/{id}")
    public String approve(@PathVariable Long id) {
        affectationService.approveAffectation(id);
        return "redirect:/affectations";
    }

    @GetMapping("/affectations/reject/{id}")
    public String reject(@PathVariable Long id) {
        affectationService.rejectAffectation(id);
        return "redirect:/affectations";
    }
}