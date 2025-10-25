package com.example.fitness.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 32)
  private String g_id;

  @Column(nullable = false, unique = true, length = 255)
  private String username;

  @Column(nullable = false, unique = true, length = 255)
  private String email;

  @Column(name = "profile_pic")
  private String profile_pic;

  @Column(nullable = false, length = 200)
  private String passwordHash;

  public User() { }


  public Long getId() { return id; }

  public String getG_id() { return g_id; }
  public void setG_id(String g_id) { this.g_id = g_id; }

  public String getUsername() { return username; }
  public void setUsername(String username) { this.username = username; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getProfile_pic() { return profile_pic; }
  public void setProfile_pic(String profile_pic) { this.profile_pic = profile_pic; }

  public String getPasswordHash() { return passwordHash; }
  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }



}
