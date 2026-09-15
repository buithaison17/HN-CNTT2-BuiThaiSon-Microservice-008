package org.example.eventservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.dto.EventRequest;
import org.example.eventservice.entity.Event;
import org.example.eventservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest request) {
        return new ResponseEntity<>(eventService.createEvent(request), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Event> findAll() {
        return eventService.findAll();
    }
}
