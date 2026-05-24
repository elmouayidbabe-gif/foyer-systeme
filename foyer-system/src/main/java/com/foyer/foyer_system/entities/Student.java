package com.foyer.foyer_system.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Frist name is requierd")
    private String firstName;
    @NotBlank(message = "Last name is requierd")
    private String lastName;
    private String email;
    private String cin;
    private java.time.LocalDate dateOfBirth;
}
