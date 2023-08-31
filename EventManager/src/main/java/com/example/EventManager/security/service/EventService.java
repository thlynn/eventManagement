package com.example.EventManager.security.service;

import com.example.EventManager.models.Event;
import com.example.EventManager.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService{
    @Autowired
    EventRepository eventRepository;
    @Override
    public String addEvent(Event event) {
        eventRepository.save(event);
        return "Add event successfully!";
    }

    @Override
    public String removeEvent(int eventID) {
        Optional<Event> event = eventRepository.findById(eventID);
        if(event.isEmpty()){
            return "ID is not found";
        }else{
            eventRepository.delete(event.get());
            return "Delete event successfully!";
        }
    }

    @Override
    public String remakeEvent(Event newEvent) {
        Optional<Event> event = eventRepository.findById(newEvent.getEventId());
        if(event.isEmpty()){
            return "ID is not found";
        }else{
            event.get().setEventId(newEvent.getEventId());
            event.get().setCategory(newEvent.getCategory());
            event.get().setDescription(newEvent.getDescription());
            event.get().setLocation(newEvent.getLocation());
            event.get().setTime(newEvent.getTime());
            event.get().setTitle(newEvent.getTitle());
            event.get().setMaxParticipant(newEvent.getMaxParticipant());
            event.get().setOrganizerId(newEvent.getOrganizerId());
            eventRepository.save(event.get());
            return "Update event successfully!";
        }
    }

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }
}
