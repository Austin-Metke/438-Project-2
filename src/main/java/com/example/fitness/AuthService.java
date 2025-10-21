package com.example.fitness;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Service
@Transactional
public class AuthService {
  private final UserRepository users;
  private final PasswordEncoder passwordEncoder;

  public AuthService(UserRepository users, PasswordEncoder passwordEncoder) {
    this.users = users;
    this.passwordEncoder = passwordEncoder;
  }

  /** Registration DTO */
  public record RegisterRequest(
      @NotBlank @Email @Size(max = 255) String email,
      @NotBlank @Size(max=255) String username,
      @NotBlank @Size(min = 8, max = 200) String password,
      @Nullable @Size(max=32) String gId
  ) {}

  public record UserDto(Long id, String email, String username) {} // Returns to client

  /* Login DTOs */
  public record LoginRequest(@NotBlank @Email String email, @NotBlank String password, String username, @Nullable String gID) {}
  public record LoginResponse(UserDto user /* , String token */) {}

  public UserDto register(RegisterRequest req) {
    if (users.existsByEmail(req.email())) {
        throw new DuplicateUserException(req.username());
    } else if(users.existsByUsername(req.username())) {
        throw new DuplicateUserException(req.email());
    }
    User u = new User();
    u.setEmail(req.email().toLowerCase());
    u.setgId(req.gId());
    u.setUsername(req.username());
    u.setPasswordHash(passwordEncoder.encode(req.password())); // BCrypt hash
    User saved = users.save(u);
    return toDto(saved);
  }

  public LoginResponse login(LoginRequest req) {
    User u = users.findByEmail(req.email().toLowerCase())
        .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

    boolean ok = passwordEncoder.matches(req.password(), u.getPasswordHash());
    if (!ok) throw new IllegalArgumentException("Invalid email or password");

    // //Add JWT later
    return new LoginResponse(toDto(u));
  }

  private static UserDto toDto(User u) {
    return new UserDto(u.getid(), u.getEmail(), u.getUsername());
  }
}
