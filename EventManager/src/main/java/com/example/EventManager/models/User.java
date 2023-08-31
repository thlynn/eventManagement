package com.example.EventManager.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JsonManagedReference
    private Set<Event> events;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    @JsonManagedReference
    private Set<registration> registrations;
    @NotBlank
    @Size(max = 20)
    @Column(name = "username",unique = true)
    private String username;
    @NotBlank
    @Size(max = 20)
    @JsonIgnore
    @Column(name = "password")
    private String password;
    @NotBlank
    @Size(max = 50)
    @Column(unique = true,name = "email")
    @Email
    private String email;
    @Size(min = 9, max = 11)
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "checkExperience")
    private boolean checkExperience;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String username, String password, String email, String phone, String address, boolean checkExperience) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.checkExperience = checkExperience;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
