package com.example.EventManager.security.service;

import com.example.EventManager.models.speaker;
import com.example.EventManager.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeakerService implements ISpeakerService{
    @Autowired
    SpeakerRepository speakerRepository;
    @Override
    public String addSpeaker(speaker speakers) {
        speakerRepository.save(speakers);
        return "Add successfully!";
    }

    @Override
    public String removeSpeaker(int speakerID) {
        Optional<speaker> speaker = speakerRepository.findById(speakerID);
        if(speaker.isEmpty()){
            return "SpeakerID not found!";
        }else{
            speakerRepository.delete(speaker.get());
            return "Delete successfully!";
        }
    }

    @Override
    public String remakeSpeaker(speaker newSpeaker) {
        Optional<speaker> speaker = speakerRepository.findById(newSpeaker.getSpeakerId());
        if(speaker.isEmpty()){
            return "SpeakerID not found!";
        }else{
            speaker.get().setSpeakerId(newSpeaker.getSpeakerId());
            speaker.get().setEmail(newSpeaker.getEmail());
            speaker.get().setFullname(newSpeaker.getFullname());
            speaker.get().setPhone(newSpeaker.getPhone());
            speakerRepository.save(speaker.get());
            return "Update successfully!";
        }
    }

    @Override
    public List<speaker> getAllSpeaker() {
        return null;
    }
}
