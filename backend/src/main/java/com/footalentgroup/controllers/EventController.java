package com.footalentgroup.controllers;

import com.footalentgroup.models.dtos.request.EventRequestDto;
import com.footalentgroup.models.dtos.response.EventResponseDto;
import com.footalentgroup.services.impl.EventServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EventController.EVENTS)
@RequiredArgsConstructor
public class EventController {

    public static final String EVENTS = "/events";

    private final EventServiceImpl eventService;

    // Método para crear un nuevo evento
    @PostMapping("/create")
    public EventResponseDto createEvent(@RequestBody EventRequestDto eventRequestDto, @RequestParam Long organizerId) {
        return eventService.createEvent(eventRequestDto, organizerId);
    }

    // Método para actualizar un evento existente
    @PutMapping("/{eventId}/update")
    public EventResponseDto updateEvent(@PathVariable Long eventId,
                                        @RequestBody EventRequestDto eventRequestDto,
                                        @RequestParam Long organizerId) {
        return eventService.updateEvent(eventId, eventRequestDto, organizerId);
    }

    // Método para eliminar un evento
    @DeleteMapping("/{eventId}/delete")
    public void deleteEvent(@PathVariable Long eventId, @RequestParam Long organizerId) {
        eventService.deleteEvent(eventId, organizerId);
    }

    // Método para buscar eventos
    @GetMapping("/search")
    public List<EventResponseDto> searchEvents(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) String date) {
        return eventService.searchEvents(name, location, category, active, date);
    }
}
