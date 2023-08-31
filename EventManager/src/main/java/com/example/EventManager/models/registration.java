package com.example.EventManager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registration")
public class registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrationId")
    private int registrationId;
    @Column(name = "userId",insertable = false,updatable = false)
    private int userId;
    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;
    @Column(name = "eventId",insertable = false,updatable = false)
    private int eventId;
    @ManyToOne
    @JoinColumn(name = "eventId")
    @JsonBackReference
    private Event event;
    @Column(name = "speakerId",insertable = false,updatable = false)
    private int speakerId;
    @ManyToOne
    @JoinColumn(name = "speakerId")
    @JsonBackReference
    private speaker speaker;
    @Column(name = "registration_date")
    private LocalDate registration_date;

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public com.example.EventManager.models.speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(com.example.EventManager.models.speaker speaker) {
        this.speaker = speaker;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }
}
