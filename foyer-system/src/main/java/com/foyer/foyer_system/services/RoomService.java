package com.foyer.foyer_system.services;

import com.foyer.foyer_system.dto.RoomDTO;
import com.foyer.foyer_system.entities.Room;

import java.util.List;

public interface RoomService {

   RoomDTO addRoom(Room room);

   List<RoomDTO> getAllRooms();

   RoomDTO getRoomById(Long id);

   RoomDTO updateRoom(Long id, Room room);

   void deleteRoom(Long id);
}