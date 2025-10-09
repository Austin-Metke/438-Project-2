package com.example.fitness;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  private final AuthService auth;

  public AuthController(AuthService auth) {
    this.auth = auth;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthService.UserDto register(@Valid @RequestBody AuthService.RegisterRequest req) {
    return auth.register(req);
  }

  @PostMapping("/login")
  public AuthService.LoginResponse login(@Valid @RequestBody AuthService.LoginRequest req) {
    return auth.login(req);
  }
}
