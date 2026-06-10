package com.lalit.aiinterviewplatform.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalit.aiinterviewplatform.dto.RegisterRequest;
import com.lalit.aiinterviewplatform.service.AuthService;

/*
 * Authentication Controller
 *
 * Purpose:
 * Exposes authentication-related APIs.
 *
 * Examples:
 * - User Registration
 * - User Login
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /*
     * AuthService contains the business logic.
     */
    private final AuthService authService;

    /*
     * Constructor Injection
     *
     * Spring automatically provides AuthService
     * when creating AuthController.
     */
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /*
     * Registration API
     *
     * Endpoint:
     * POST /api/auth/register
     *
     * Receives registration data from the client
     * and passes it to AuthService.
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {

        // Call service layer to register the user
        authService.registerUser(request);

        // Simple success response
        return "User registered successfully";
    }

}