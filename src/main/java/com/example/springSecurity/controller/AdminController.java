package com.example.springSecurity.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
@Tag(name = "Admin Management", description = "Admin-related endpoints")
public class AdminController {

    @Operation(summary = "Get admin profile", description = "Returns the admin profile details")
    @GetMapping("/profile")
    public String adminProfile() {
        return "Welcome to the Admin Profile!";
    }

    @Operation(summary = "Get admin dashboard", description = "Returns the admin dashboard view")
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }
}