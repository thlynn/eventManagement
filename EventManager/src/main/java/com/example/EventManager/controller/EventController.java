package com.example.EventManager.controller;

import com.example.EventManager.models.Event;
import com.example.EventManager.security.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/event")
public class EventController {
    @Autowired
    EventService eventService;
    @RequestMapping(value = "addEvent",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String addEvent(@RequestBody Event event)
    {
        return eventService.addEvent(event);
    }
    @RequestMapping(value = "removeEvent",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String removeEvent(@RequestParam int eventID)
    {
        return eventService.removeEvent(eventID);
    }
    @RequestMapping(value = "remakeEvent",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String remakeEvent(@RequestBody Event newEvent)
    {
        return eventService.remakeEvent(newEvent);
    }
    @RequestMapping(value = "getAllEvent",method = RequestMethod.GET)
    public List<Event> getAllEvent()
    {
        return eventService.getAllEvent();
    }
}
