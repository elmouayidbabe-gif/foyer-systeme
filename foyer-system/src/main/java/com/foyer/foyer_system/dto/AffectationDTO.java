package com.foyer.foyer_system.dto;

import com.foyer.foyer_system.entities.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AffectationDTO {

    private Long id;

    private Long studentId;
    private String studentName;

    private Long roomId;
    private String roomNumber;

    private Status status;
}