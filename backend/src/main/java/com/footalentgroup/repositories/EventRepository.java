package com.footalentgroup.repositories;

import com.footalentgroup.models.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    // Búsqueda filtrada con parámetros opcionales
    @Query("SELECT e FROM EventEntity e WHERE " +
            "(:category IS NULL OR e.category = :category) AND " +
            "(:location IS NULL OR e.location = :location) AND " +
            "(:date IS NULL OR e.date = :date) AND " +
            "(:active IS NULL OR e.active = :active)")
    List<EventEntity> searchEvents(
            @Param("category") String category,
            @Param("location") String location,
            @Param("date") LocalDateTime date,
            @Param("active") Boolean active
    );

    // Buscar eventos por el ID del músico
    List<EventEntity> findAllByMusician_Id(Long id);
}