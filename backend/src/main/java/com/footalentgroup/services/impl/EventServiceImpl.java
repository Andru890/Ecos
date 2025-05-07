import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final MusicianProfileRepository musicianProfileRepository;

    // Método para crear un evento
    @Override
    @Transactional
    public EventResponseDto createEvent(EventRequestDto eventRequestDto, Long musicianId) {
        MusicianProfileEntity musician = musicianProfileRepository.findById(musicianId)
                .orElseThrow(() -> new RuntimeException("Musician not found"));

        EventEntity event = EventEntity.builder()
                .name(eventRequestDto.getName())
                .category(eventRequestDto.getCategory())
                .date(eventRequestDto.getDate())
                .location(eventRequestDto.getLocation())
                .description(eventRequestDto.getDescription())
                .image(eventRequestDto.getImage())
                .active(true)
                .musician(musician)
                .build();

        EventEntity savedEvent = eventRepository.save(event);

        return mapToDto(savedEvent);
    }

    // Método para actualizar un evento
    @Override
    @Transactional
    public EventResponseDto updateEvent(Long eventId, EventRequestDto eventRequestDto, Long musicianId) {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (!event.getMusician().getId().equals(musicianId)) {
            throw new RuntimeException("Musician is not authorized to update this event");
        }

        event.setName(eventRequestDto.getName());
        event.setCategory(eventRequestDto.getCategory());
        event.setDate(eventRequestDto.getDate());
        event.setLocation(eventRequestDto.getLocation());
        event.setDescription(eventRequestDto.getDescription());
        event.setImage(eventRequestDto.getImage());

        EventEntity updatedEvent = eventRepository.save(event);

        return mapToDto(updatedEvent);
    }

    // Método para eliminar un evento
    @Override
    @Transactional
    public void deleteEvent(Long eventId, Long musicianId) {
        EventEntity event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (!event.getMusician().getId().equals(musicianId)) {
            throw new RuntimeException("Musician is not authorized to delete this event");
        }

        eventRepository.delete(event);
    }

    // Método para ver eventos con filtros
    @Override
    @Transactional(readOnly = true)
    public List<EventResponseDto> getEventsByFilters(String category, String location, LocalDateTime date, Boolean active) {
        List<EventEntity> events = eventRepository.findByCategoryAndLocationAndDateAndActive(category, location, date, active);

        return events.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // Método para obtener eventos de un músico por su ID
    @Override
    @Transactional(readOnly = true)
    public List<EventResponseDto> getEventsByMusicianId(Long musicianId) {
        List<EventEntity> events = eventRepository.findAllByMusician_Id(musicianId);

        return events.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    // Método para mapear una entidad de evento a un DTO de respuesta
    private EventResponseDto mapToDto(EventEntity event) {
        return EventResponseDto.builder()
                .id(event.getId())
                .name(event.getName())
                .category(event.getCategory())
                .date(event.getDate())
                .location(event.getLocation())
                .description(event.getDescription())
                .image(event.getImage())
                .active(event.getActive())
                .musicianId(event.getMusician().getId())
                .musicianStageName(event.getMusician().getStageName())
                .build();
    }
}
