package com.foyer.foyer_system.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long id;

    private String roomNumber;

    private String type;

    private int capacity;
}