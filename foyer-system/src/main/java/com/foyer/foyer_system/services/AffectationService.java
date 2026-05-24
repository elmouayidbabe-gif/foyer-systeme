package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.entities.Affectation;
import java.util.List;

public interface AffectationService {

    AffectationDTO addAffectation(Affectation affectation);

    List<AffectationDTO> getAllAffectations();

    AffectationDTO getAffectationById(Long id);

    void deleteAffectation(Long id);
}