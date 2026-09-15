package org.example.eventservice.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Organizer {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
