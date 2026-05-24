package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.entities.Affectation;
import com.foyer.foyer_system.services.AffectationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.foyer.foyer_system.responses.ApiResponse;


import java.util.List;

@RestController
@RequestMapping("/affectations")
@RequiredArgsConstructor
public class AffectationRestController {

    private final AffectationService affectationService;

    @PostMapping
    public ApiResponse<AffectationDTO>
    addAffectation(@RequestBody Affectation affectation){
        return  new ApiResponse<>(
                "success",
                "Affectation created successfully",
                affectationService.addAffectation(affectation)
        );
    }

    @GetMapping
    public ApiResponse<List<AffectationDTO>>
    getAllAffectations(){
        return new ApiResponse<>(
                "success",
                "Affectations retrivied successfully",
                affectationService.getAllAffectations()
                );
    }

    @GetMapping("/{id}")
    public ApiResponse<AffectationDTO> getAffectationById(@PathVariable Long id){
        return new ApiResponse<>(
                "success",
                "Affectation found",
                affectationService.getAffectationById(id)
        );
    }

    @DeleteMapping("/{id}")
    public void deleteAffectation(@PathVariable Long id){
        affectationService.deleteAffectation(id);
    }
}
