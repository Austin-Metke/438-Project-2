package com.example.fitness.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String g_id;
    private String username;
    private String email;
    private String profile_pic;

    public user(String g_id, String username, String email, String profile_pic) {
        this.g_id = g_id;
        this.username = username;
        this.email = email;
        this.profile_pic = profile_pic;
    }

    public Long getId() {
        return id;
    }

    public String getG_id() {
        return g_id;
    }

    public void setG_id(String g_id) {
        this.g_id = g_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }
}
