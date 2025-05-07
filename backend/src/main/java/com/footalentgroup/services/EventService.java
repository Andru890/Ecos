package com.footalentgroup.services;

import com.footalentgroup.models.dtos.request.EventRequestDto;
import com.footalentgroup.models.dtos.response.EventResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    // Crear un nuevo evento
    EventResponseDto createEvent(EventRequestDto eventRequestDto, Long musicianId);

    // Actualizar un evento existente
    EventResponseDto updateEvent(Long eventId, EventRequestDto eventRequestDto, Long musicianId);

    // Eliminar un evento
    void deleteEvent(Long eventId, Long musicianId);

    // Obtener eventos filtrados
    List<EventResponseDto> getEventsByFilters(String category, String location, LocalDateTime date, Boolean active);

    // Obtener eventos por ID del músico
    List<EventResponseDto> getEventsByMusicianId(Long musicianId);
}