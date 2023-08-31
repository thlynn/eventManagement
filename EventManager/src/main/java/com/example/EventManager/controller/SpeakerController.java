package com.example.EventManager.controller;

import com.example.EventManager.models.Event;
import com.example.EventManager.models.speaker;
import com.example.EventManager.security.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/speaker")
public class SpeakerController {
    @Autowired
    SpeakerService speakerService;
    @RequestMapping(value = "addSpeaker",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String addSpeaker(@RequestBody speaker speakers)
    {
        return speakerService.addSpeaker(speakers);
    }
    @RequestMapping(value = "removeSpeaker",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String removeSpeaker(@RequestParam int speakerID)
    {
        return speakerService.removeSpeaker(speakerID);
    }
    @RequestMapping(value = "remakeSpeaker",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasRole('MODERATOR')")
    public String remakeSpeaker(@RequestBody speaker newSpeaker)
    {
        return speakerService.remakeSpeaker(newSpeaker);
    }
}
