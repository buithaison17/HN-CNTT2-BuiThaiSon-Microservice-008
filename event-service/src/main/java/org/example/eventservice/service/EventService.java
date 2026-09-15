package org.example.eventservice.service;

import lombok.RequiredArgsConstructor;
import org.example.eventservice.client.OrganizerClient;
import org.example.eventservice.dto.EventRequest;
import org.example.eventservice.dto.Organizer;
import org.example.eventservice.entity.Event;
import org.example.eventservice.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EventService {
    private final OrganizerClient organizerClient;
    private final EventRepository eventRepository;

    public Event createEvent(EventRequest request) {
        Organizer organizer = organizerClient.getOrganizerById(request.organizerId());
        if (organizer == null) {
            throw new NoSuchElementException("Organizer not found");
        }
        Event event = Event.builder()
                .organizerId(request.organizerId())
                .eventName(request.eventName())
                .status(request.status())
                .build();
        return eventRepository.save(event);
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }
}
