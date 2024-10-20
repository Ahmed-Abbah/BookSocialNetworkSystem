package abbah.ahmed.BookSocialNetwork.service;


import abbah.ahmed.BookSocialNetwork.entity.Event;
import abbah.ahmed.BookSocialNetwork.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    public EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }

    public Event getEvent(Long eventId){
        Optional<Event> optionalEvent = this.eventRepository.findById(eventId);
        return optionalEvent.orElse(null);
    }

    public List<Event> eventList(){
        return this.eventRepository.findAll();
    }

    public Event updateEvent(Event newEvent){
        return this.eventRepository.save(newEvent);
    }

    public void deleteEvent(Long id){
        Event foundEvent = this.getEvent(id);
       this.eventRepository.delete(foundEvent);
    }

    public Event saveEvent(Event event){
        return this.eventRepository.save(event);
    }
}
