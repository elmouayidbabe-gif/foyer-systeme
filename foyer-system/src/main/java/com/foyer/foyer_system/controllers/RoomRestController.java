package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.dto.RoomDTO;
import com.foyer.foyer_system.entities.Room;
import com.foyer.foyer_system.responses.ApiResponse;
import com.foyer.foyer_system.services.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomRestController {

    private final RoomService roomService;

    // ---------------- GET ALL ----------------
    @GetMapping
    public ApiResponse<List<RoomDTO>> getAllRooms() {

        return new ApiResponse<>(
                "success",
                "Rooms retrieved successfully",
                roomService.getAllRooms()
        );
    }

    // ---------------- GET BY ID ----------------
    @GetMapping("/{id}")
    public ApiResponse<RoomDTO> getRoomById(@PathVariable Long id) {

        return new ApiResponse<>(
                "success",
                "Room found",
                roomService.getRoomById(id)
        );
    }

    // ---------------- ADD ----------------
    @PostMapping
    public ApiResponse<RoomDTO> addRoom(@Valid @RequestBody Room room) {

        return new ApiResponse<>(
                "success",
                "Room created successfully",
                roomService.addRoom(room)
        );
    }

    // ---------------- DELETE ----------------
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteRoom(@PathVariable Long id) {

        roomService.deleteRoom(id);

        return new ApiResponse<>(
                "success",
                "Room deleted successfully",
                "deleted"
        );
    }
}