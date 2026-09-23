package com.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    // Sample login endpoint
    // In production: validate credentials, generate real JWT
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> credentials) {

        String username = credentials.get("username");
        String password = credentials.get("password");

        // Basic validation
        if (username == null || password == null) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "Username and password required"));
        }

        // In production: validate against DB, use BCrypt, generate JWT
        Map<String, String> response = new HashMap<>();
        response.put("token", "eyJhbGciOiJIUzI1NiJ9.sample.token");
        response.put("type", "Bearer");
        response.put("username", username);
        response.put("role", "ADMIN");
        response.put("message", "Login successful");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(
            @RequestBody Map<String, String> userData) {

        String username = userData.get("username");
        String email = userData.get("email");

        if (username == null || email == null) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "Username and email required"));
        }

        return ResponseEntity.ok(
            Map.of("message", "User registered successfully",
                   "username", username)
        );
    }
}
