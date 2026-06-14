package com.foyer.foyer_system.controllers;

import com.foyer.foyer_system.entities.Room;
import com.foyer.foyer_system.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class RoomPageController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public String rooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("room", new Room());
        return "rooms";
    }

    @PostMapping("/rooms/save")
    public String saveRoom(@ModelAttribute Room room) {

        if (room.getId() == null) {
            roomService.addRoom(room);
        } else {
            roomService.updateRoom(room.getId(), room);
        }

        return "redirect:/rooms";
    }

    @GetMapping("/rooms/edit/{id}")
    public String editRoom(@PathVariable Long id, Model model) {

        Room room = roomService.getRoomByIdEntity(id);

        model.addAttribute("room", room);
        model.addAttribute("rooms", roomService.getAllRooms());

        return "rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/rooms";
    }
}