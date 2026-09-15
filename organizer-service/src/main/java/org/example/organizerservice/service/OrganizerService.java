package org.example.organizerservice.service;

import lombok.RequiredArgsConstructor;
import org.example.organizerservice.dto.OrganizerRequest;
import org.example.organizerservice.entity.Organizer;
import org.example.organizerservice.repository.OrganizerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizerService {
    private final List<Organizer> organizers = new ArrayList<>();
    private final OrganizerRepository organizerRepository;

    public Organizer createOrganizer(OrganizerRequest organizerRequest) {
        Organizer organizer = Organizer.builder()
                .name(organizerRequest.name())
                .email(organizerRequest.email())
                .address(organizerRequest.address())
                .phone(organizerRequest.phone())
                .build();
        return organizerRepository.save(organizer);
    }

    public Organizer findById(Long id) {
        return organizerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Organizer not found"));
    }

    public void deleteOrganizer(Long id) {
        Organizer organizer = findById(id);
        organizerRepository.delete(organizer);
    }

    public Organizer updateOrganizer(Long id, OrganizerRequest request){
        Organizer organizer = findById(id);
        organizer.setName(request.name());
        organizer.setEmail(request.email());
        organizer.setAddress(request.address());
        organizer.setPhone(request.phone());
        return organizerRepository.save(organizer);
    }
}
