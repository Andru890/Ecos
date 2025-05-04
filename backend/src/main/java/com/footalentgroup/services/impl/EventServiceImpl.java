package com.footalentgroup.services.impl;

import com.footalentgroup.models.dtos.request.EventRequestDto;
import com.footalentgroup.models.dtos.response.EventResponseDto;
import com.footalentgroup.models.entities.EventEntity;
import com.footalentgroup.repositories.EventRepository;
import com.footalentgroup.repositories.OrganizerUserRepository;
import com.footalentgroup.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final OrganizerUserRepository organizerUserRepository;

    // Método para crear un evento
    @Override
    @Transactional
    public EventResponseDto createEvent(EventRequestDto eventRequestDto, Long organizerId) {
        EventEntity event = EventEntity.builder()
                .name(eventRequestDto.getName())
                .category(eventRequestDto.getCategory())
                .date(LocalDateTime.parse(eventRequestDto.getDate()))
                .location(eventRequestDto.getLocation())
                .description(eventRequestDto.getDescription())
                .image(eventRequestDto.getImage())
                .active(true)
                .organizer(organizerUserRepository.findById(organizerId)
                        .orElseThrow(() -> new RuntimeException("Organizer not found")))
                .build();

        EventEntity savedEvent = eventRepository.save(event);

        return EventResponseDto.builder()
                .id(savedEvent.getId())
                .name(savedEvent.getName())
                .category(savedEvent.getCategory())
                .date(savedEvent.getDate())
                .location(savedEvent.getLocation())
                .description(savedEvent.getDescription())
                .image(savedEvent.getImage())
                .active(savedEvent.getActive())
                .organizer(organizerId)
                .build();
    }

    // Método para actualizar un evento
    @Override
    @Transactional
    public EventResponseDto updateEvent(Long eventId, EventRequestDto eventRequestDto, Long organizerId) {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setName(eventRequestDto.getName());
        event.setCategory(eventRequestDto.getCategory());
        event.setDate(LocalDateTime.parse(eventRequestDto.getDate()));
        event.setLocation(eventRequestDto.getLocation());
        event.setDescription(eventRequestDto.getDescription());
        event.setImage(eventRequestDto.getImage());

        EventEntity updatedEvent = eventRepository.save(event);

        return EventResponseDto.builder()
                .id(updatedEvent.getId())
                .name(updatedEvent.getName())
                .category(updatedEvent.getCategory())
                .date(updatedEvent.getDate())
                .location(updatedEvent.getLocation())
                .description(updatedEvent.getDescription())
                .image(updatedEvent.getImage())
                .active(updatedEvent.getActive())
                .organizer(organizerId)
                .build();
    }

    // Método para eliminar un evento
    @Override
    @Transactional
    public void deleteEvent(Long eventId, Long organizerId) {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Verificar que el organizador que quiere eliminar el evento sea el mismo que lo creó
        if (!event.getOrganizer().getId().equals(organizerId)) {
            throw new RuntimeException("Organizer is not authorized to delete this event");
        }

        eventRepository.delete(event);
    }
}
