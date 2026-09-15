package org.example.organizerservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.organizerservice.dto.OrganizerRequest;
import org.example.organizerservice.entity.Organizer;
import org.example.organizerservice.service.OrganizerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organizers")
@RequiredArgsConstructor
public class OrganizerController {
    private final OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody OrganizerRequest request) {
        return organizerService.createOrganizer(request);
    }

    @PostMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody OrganizerRequest request) {
        return organizerService.updateOrganizer(id, request);
    }

    @GetMapping("/{id}")
    public Organizer getOrganizer(@PathVariable Long id) {
        return organizerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
    }
}
