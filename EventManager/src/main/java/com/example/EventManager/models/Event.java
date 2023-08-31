package com.example.EventManager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private int eventId;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "event")
    @JsonManagedReference
    private Set<registration> registrations;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "time")
    private LocalDate time;
    @Column(name = "location")
    private String location;
    @Column(name = "organizerId",insertable = false,updatable = false)
    private int organizerId;
    @ManyToOne
    @JoinColumn(name = "organizerId")
    @JsonBackReference
    private User user;
    @Column(name = "category")
    private String category;
    @Column(name = "maxParticipant")
    private int maxParticipant;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Set<registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<registration> registrations) {
        this.registrations = registrations;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaxParticipant() {
        return maxParticipant;
    }

    public void setMaxParticipant(int maxParticipant) {
        this.maxParticipant = maxParticipant;
    }
}
