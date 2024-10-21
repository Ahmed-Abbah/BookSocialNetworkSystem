package abbah.ahmed.BookSocialNetwork.service;

import abbah.ahmed.BookSocialNetwork.entity.Event;
import abbah.ahmed.BookSocialNetwork.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEvent() {
        Long eventId = 1L;
        Event mockEvent = new Event();
        mockEvent.setId(eventId);

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));

        Event event = eventService.getEvent(eventId);

        assertNotNull(event);
        assertEquals(eventId, event.getId());
        verify(eventRepository, times(1)).findById(eventId);
    }

    @Test
    void testEventList() {
        Event event1 = new Event();
        Event event2 = new Event();
        List<Event> mockEvents = Arrays.asList(event1, event2);

        when(eventRepository.findAll()).thenReturn(mockEvents);

        List<Event> events = eventService.eventList();

        assertEquals(2, events.size());
        verify(eventRepository, times(1)).findAll();
    }

    @Test
    void testUpdateEvent() {
        Event newEvent = new Event();
        newEvent.setId(1L);

        when(eventRepository.save(newEvent)).thenReturn(newEvent);

        Event updatedEvent = eventService.saveEvent(newEvent);

        assertNotNull(updatedEvent);
        assertEquals(1L, updatedEvent.getId());
        verify(eventRepository, times(1)).save(newEvent);
    }

    @Test
    void testDeleteEvent() {
        Long eventId = 1L;
        Event mockEvent = new Event();
        mockEvent.setId(eventId);

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));

        eventService.deleteEvent(eventId);

        verify(eventRepository, times(1)).delete(mockEvent);
    }

    @Test
    void testSaveEvent() {
        Event event = new Event();

        when(eventRepository.save(event)).thenReturn(event);

        Event savedEvent = eventService.saveEvent(event);

        assertNotNull(savedEvent);
        verify(eventRepository, times(1)).save(event);
    }
}

