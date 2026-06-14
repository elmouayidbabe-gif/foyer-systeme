package com.foyer.foyer_system.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String cin;

    private LocalDate dateOfBirth;
}
