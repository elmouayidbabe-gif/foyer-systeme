package com.foyer.foyer_system.responses;
import lombok.*;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;

}
