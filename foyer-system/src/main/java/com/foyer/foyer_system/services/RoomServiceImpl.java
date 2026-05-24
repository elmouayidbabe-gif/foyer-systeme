package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.RoomDTO;
import com.foyer.foyer_system.entities.Room;
import com.foyer.foyer_system.repositories.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    // ---------------- MAPPER ----------------
    private RoomDTO mapToDTO(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getRoomNumber(),
                room.getCapacity()
        );
    }

    // ---------------- ADD ----------------
    @Override
    public RoomDTO addRoom(Room room) {
        Room saved = roomRepository.save(room);
        return mapToDTO(saved);
    }

    // ---------------- GET ALL ----------------
    @Override
    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // ---------------- GET BY ID ----------------
    @Override
    public RoomDTO getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        return mapToDTO(room);
    }

    // ---------------- UPDATE ----------------
    @Override
    public RoomDTO updateRoom(Long id, Room room) {

        Room existing = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        existing.setRoomNumber(room.getRoomNumber());
        existing.setCapacity(room.getCapacity());

        Room updated = roomRepository.save(existing);

        return mapToDTO(updated);
    }

    // ---------------- DELETE ----------------
    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}