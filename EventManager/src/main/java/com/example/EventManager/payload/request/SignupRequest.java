package com.example.EventManager.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String username;
    @NotBlank
    @Size(max = 20)
    @JsonIgnore
    private String password;
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    @Email
    private String email;
    @Size(min = 9, max = 11)
    private String phone;
    private String address;
    private boolean checkExperience;
    private Set<String> role;

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCheckExperience() {
        return checkExperience;
    }

    public void setCheckExperience(boolean checkExperience) {
        this.checkExperience = checkExperience;
    }
}
