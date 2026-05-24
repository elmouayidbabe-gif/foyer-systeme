package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.entities.Affectation;
import com.foyer.foyer_system.entities.Room;
import com.foyer.foyer_system.repositories.AffectationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AffectationServiceImpl implements AffectationService {

    private final AffectationRepository affectationRepository;

    // ---------------- MAPPING ----------------
    private AffectationDTO mapToDTO(Affectation affectation) {
        AffectationDTO dto = new AffectationDTO();
        dto.setId(affectation.getId());
        dto.setStudentId(affectation.getStudent().getId());
        dto.setRoomId(affectation.getRoom().getId());
        return dto;
    }

    // ---------------- ADD ----------------
    @Override
    public AffectationDTO addAffectation(Affectation affectation) {

        Room room = affectation.getRoom();

        int currentStudents =
                (room.getAffectations() == null) ? 0 : room.getAffectations().size();

        if (currentStudents >= room.getCapacity()) {
            throw new RuntimeException("Room is full");
        }

        List<Affectation> existing = affectationRepository.findByStudentId(
                affectation.getStudent().getId()
        );

        if (!existing.isEmpty()) {
            throw new RuntimeException("Student already has a room");
        }

        Affectation saved = affectationRepository.save(affectation);
        return mapToDTO(saved);
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<AffectationDTO> getAllAffectations() {
        return affectationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------------- GET BY ID ----------------
    @Override
    public AffectationDTO getAffectationById(Long id) {
        Affectation affectation = affectationRepository.findById(id)
                .orElse(null);

        if (affectation == null) return null;

        return mapToDTO(affectation);
    }

    // ---------------- DELETE ----------------
    @Override
    public void deleteAffectation(Long id) {
        affectationRepository.deleteById(id);
    }
}