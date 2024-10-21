package abbah.ahmed.BookSocialNetwork.controller;



import abbah.ahmed.BookSocialNetwork.entity.Event;
import abbah.ahmed.BookSocialNetwork.service.EventService;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        Event event = this.eventService.getEvent(id);
        return new ResponseEntity<>(event, HttpStatus.FOUND);
    }


    @PostMapping("")
    public ResponseEntity<Event> addEvent(@RequestBody Event event){
        this.eventService.saveEvent(event);
        return new ResponseEntity<>(event,HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id,@RequestBody Event event){
        Event existingEvent = this.eventService.getEvent(id);
        if(existingEvent!=null){
            Event newEvent = Event.builder()
                    .id(id)
                    .date(event.getDate())
                    .location(event.getLocation())
                    .capacity(event.getCapacity())
                    .title(event.getTitle())
                    .build();
            this.eventService.saveEvent(newEvent);
            return new ResponseEntity<>(newEvent,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        Event event = this.eventService.getEvent(id);
        if(event!=null){
            this.eventService.deleteEvent(id);
            return new ResponseEntity<>("Event with id : "+id+" deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Event with id : "+id+" was not Found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Event>> listEvents() {
        List<Event> events = this.eventService.eventList();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
