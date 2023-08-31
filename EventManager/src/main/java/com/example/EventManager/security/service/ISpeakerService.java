package com.example.EventManager.security.service;

import com.example.EventManager.models.speaker;

import java.util.List;

public interface ISpeakerService {
    public String addSpeaker(speaker speakers);
    public String removeSpeaker(int speakerID);
    public String remakeSpeaker(speaker newSpeaker);
    public List<speaker> getAllSpeaker();
}
