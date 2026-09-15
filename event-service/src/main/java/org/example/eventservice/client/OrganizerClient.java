package org.example.eventservice.client;

import org.example.eventservice.dto.Organizer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("organizer-service")
public interface OrganizerClient {
    @GetMapping("/api/v1/organizers/{id}")
    Organizer getOrganizerById(@PathVariable Long id);
}
