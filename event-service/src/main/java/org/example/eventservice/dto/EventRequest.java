package org.example.eventservice.dto;

public record EventRequest(
        Long organizerId,
        String eventName,
        String status
) {
}
