package com.example.fitness;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity @Table(name="users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = true)
  private String gId;

  @Email @Column(nullable=false, unique = true)
  private String email;

  @NotBlank @Column(nullable = false)
  private String passwordHash;

  @NotBlank @Column(nullable = false)
  private String username;

  public String getgId() {
    return this.gId;
  }

  public void setgId(String gId) {
    this.gId = gId;
  }

  public Long getid() {
    return this.id;
  } 

  public void setid(long id) {
    this.id = id;
  }

  public String getPasswordHash() {
    return this.passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return this.email;
  }


}
