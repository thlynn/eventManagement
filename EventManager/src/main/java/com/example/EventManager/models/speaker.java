package com.example.EventManager.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "speaker")
public class speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speakerId")
    private int speakerId;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "speaker")
    @JsonManagedReference
    private Set<registration> registrations;
    @Column(name = "fullname")
    private String fullname;
    @NotBlank
    @Size(max = 50)
    @Column(name = "email",unique = true)
    @Email
    private String email;
    @Size(min = 9, max = 11)
    @Column(name = "phone")
    private String phone;

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public Set<registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<registration> registrations) {
        this.registrations = registrations;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
