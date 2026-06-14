package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.AffectationDTO;
import com.foyer.foyer_system.entities.Affectation;
import com.foyer.foyer_system.entities.Room;
import com.foyer.foyer_system.entities.Status;
import com.foyer.foyer_system.entities.Student;
import com.foyer.foyer_system.repositories.AffectationRepository;
import com.foyer.foyer_system.repositories.RoomRepository;
import com.foyer.foyer_system.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AffectationServiceImpl implements AffectationService {

    private final AffectationRepository affectationRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    // ================= MAPPING =================
    private AffectationDTO mapToDTO(Affectation a) {

        AffectationDTO dto = new AffectationDTO();

        dto.setId(a.getId());

        if (a.getStudent() != null) {
            dto.setStudentId(a.getStudent().getId());
            dto.setStudentName(
                    a.getStudent().getFirstName() + " " + a.getStudent().getLastName()
            );
        }

        if (a.getRoom() != null) {
            dto.setRoomId(a.getRoom().getId());
            dto.setRoomNumber(a.getRoom().getRoomNumber());
        }

        dto.setStatus(a.getStatus());

        return dto;
    }

    // ================= CREATE =================
    @Override
    public AffectationDTO addAffectation(AffectationDTO dto) {

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Affectation a = new Affectation();

        a.setStudent(student);
        a.setRoom(room);
        a.setStatus(Status.PENDING);

        return mapToDTO(affectationRepository.save(a));
    }

    // ================= GET ALL =================
    @Override
    public List<AffectationDTO> getAllAffectations() {
        return affectationRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ================= GET BY ID =================
    @Override
    public AffectationDTO getAffectationById(Long id) {

        Affectation a = affectationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation not found"));

        return mapToDTO(a);
    }

    // ================= DELETE =================
    @Override
    public void deleteAffectation(Long id) {
        affectationRepository.deleteById(id);
    }

    // ================= APPROVE =================
    @Override
    public AffectationDTO approveAffectation(Long id) {

        Affectation a = affectationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation not found"));

        a.setStatus(Status.APPROVED);

        return mapToDTO(affectationRepository.save(a));
    }

    // ================= REJECT =================
    @Override
    public AffectationDTO rejectAffectation(Long id) {

        Affectation a = affectationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation not found"));

        a.setStatus(Status.REJECTED);

        return mapToDTO(affectationRepository.save(a));
    }

    // ================= PENDING =================
    @Override
    public AffectationDTO setPending(Long id) {

        Affectation a = affectationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation not found"));

        a.setStatus(Status.PENDING);

        return mapToDTO(affectationRepository.save(a));
    }
    @Override
    public AffectationDTO updateAffectation(Long id, AffectationDTO dto) {

        Affectation a = affectationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Affectation not found"));

        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Room room = roomRepository.findById(dto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        a.setStudent(student);
        a.setRoom(room);
        a.setStatus(dto.getStatus());

        return mapToDTO(affectationRepository.save(a));
    }
}