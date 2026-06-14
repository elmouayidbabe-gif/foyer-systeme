package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.AffectationDTO;

import java.util.List;

public interface AffectationService {

    AffectationDTO addAffectation(AffectationDTO dto);

    List<AffectationDTO> getAllAffectations();

    AffectationDTO getAffectationById(Long id);

    AffectationDTO updateAffectation(Long id, AffectationDTO dto);

    void deleteAffectation(Long id);

    AffectationDTO approveAffectation(Long id);

    AffectationDTO rejectAffectation(Long id);

    AffectationDTO setPending(Long id);
}