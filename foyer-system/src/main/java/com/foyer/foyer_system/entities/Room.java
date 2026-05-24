package com.foyer.foyer_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Room number is requierd")
    private String roomNumber;
    private String type;
    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;
    @OneToMany(mappedBy= "room")
    private List<Affectation> affectations;
}
