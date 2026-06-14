package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.responses.ApiResponse;
import com.foyer.foyer_system.services.AffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affectations")
@RequiredArgsConstructor
public class AffectationRestController {

    private final AffectationService affectationService;

    // ---------------- CREATE ----------------
    @PostMapping
    public ApiResponse<AffectationDTO> addAffectation(@RequestBody AffectationDTO dto) {
        return new ApiResponse<>(
                "success",
                "Affectation created successfully",
                affectationService.addAffectation(dto)
        );
    }

    // ---------------- GET ALL ----------------
    @GetMapping
    public ApiResponse<List<AffectationDTO>> getAllAffectations() {
        return new ApiResponse<>(
                "success",
                "Affectations retrieved successfully",
                affectationService.getAllAffectations()
        );
    }

    // ---------------- GET BY ID ----------------
    @GetMapping("/{id}")
    public ApiResponse<AffectationDTO> getAffectationById(@PathVariable Long id) {
        return new ApiResponse<>(
                "success",
                "Affectation found",
                affectationService.getAffectationById(id)
        );

    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteAffectation(@PathVariable Long id) {
        affectationService.deleteAffectation(id);

        return new ApiResponse<>(
                "success",
                "Affectation deleted successfully",
                null
        );
    }

    // ---------------- WORKFLOW ----------------

    @PutMapping("/{id}/approve")
    public ApiResponse<AffectationDTO> approve(@PathVariable Long id) {
        return new ApiResponse<>(
                "success",
                "Affectation approved",
                affectationService.approveAffectation(id)
        );
    }

    @PutMapping("/{id}/reject")
    public ApiResponse<AffectationDTO> reject(@PathVariable Long id) {
        return new ApiResponse<>(
                "success",
                "Affectation rejected",
                affectationService.rejectAffectation(id)
        );
    }

    @PutMapping("/{id}/pending")
    public ApiResponse<AffectationDTO> pending(@PathVariable Long id) {
        return new ApiResponse<>(
                "success",
                "Affectation set to pending",
                affectationService.setPending(id)
        );
    }
    @PutMapping("/{id}")
    public ApiResponse<AffectationDTO> updateAffectation(
            @PathVariable Long id,
            @RequestBody AffectationDTO dto
    ) {

        return new ApiResponse<>(
                "success",
                "Affectation updated successfully",
                affectationService.updateAffectation(id, dto)
        );
    }
}