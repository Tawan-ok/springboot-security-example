package com.example.springSecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "User-related endpoints")
public class UserController {

    @Operation(summary = "Get user profile", description = "Returns the user profile details")
    @GetMapping("/profile")
    public String userProfile() {
        return "Welcome to the User Profile!";
    }

    @Operation(summary = "Get user dashboard", description = "Returns the user dashboard view")
    @GetMapping("/dashboard")
    public String userDashboard() {
        return "Welcome to the User Dashboard!";
    }
}