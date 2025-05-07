package com.footalentgroup.controllers;

import com.footalentgroup.models.dtos.request.EventRequestDto;
import com.footalentgroup.models.dtos.response.EventResponseDto;
import com.footalentgroup.services.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(EventController.EVENTS)
@RequiredArgsConstructor
public class EventController {

    public static final String EVENTS = "/events";

    private final EventServiceImpl eventService;

    // Método para crear un nuevo evento
    @PostMapping("/create")
    public EventResponseDto createEvent(@RequestBody EventRequestDto eventRequestDto, @RequestParam Long musicianId) {
        return eventService.createEvent(eventRequestDto, musicianId);
    }

    // Método para actualizar un evento existente
    @PutMapping("/{eventId}/update")
    public EventResponseDto updateEvent(@PathVariable Long eventId,
                                        @RequestBody EventRequestDto eventRequestDto,
                                        @RequestParam Long musicianId) {
        return eventService.updateEvent(eventId, eventRequestDto, musicianId);
    }

    // Método para eliminar un evento
    @DeleteMapping("/{eventId}/delete")
    public void deleteEvent(@PathVariable Long eventId, @RequestParam Long musicianId) {
        eventService.deleteEvent(eventId, musicianId);
    }

    // Método para buscar eventos con filtros
    @GetMapping("/search")
    public List<EventResponseDto> searchEvents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) LocalDateTime date) {
        return eventService.searchEvents(name, location, category, active, date);
    }
}