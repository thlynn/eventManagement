package com.example.EventManager.security.service;

import com.example.EventManager.models.Event;

import java.util.List;

public interface IEventService {
    public String addEvent(Event event);
    public String removeEvent(int eventID);
    public String remakeEvent(Event newEvent);
    public List<Event> getAllEvent();
}
