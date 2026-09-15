package org.example.organizerservice.dto;

public record OrganizerRequest(
        String name,
        String email,
        String phone,
        String address
) {
}
