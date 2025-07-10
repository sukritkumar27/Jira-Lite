package com.sukrit.jira_backend.controller;

import com.sukrit.jira_backend.dto.auth.AuthRequestDto;
import com.sukrit.jira_backend.dto.user.UserDto;
import com.sukrit.jira_backend.entity.User;
import com.sukrit.jira_backend.service.UserService;
import com.sukrit.jira_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto req) {
        // 1. Authenticate username/password
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        // 2. Load your UserDetails (to include roles, etc.)
        UserDto user = userService.getUserByUsername(req.getEmail());

        // 3. Generate a JWT—using user.getUsername() or user.getId()
        String token = jwtUtil.generateToken(user.getId());

        // 4. Return the token
        return ResponseEntity.ok(Map.of("token", token));
    }
}