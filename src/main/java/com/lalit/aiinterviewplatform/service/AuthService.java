package com.lalit.aiinterviewplatform.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.lalit.aiinterviewplatform.dto.RegisterRequest;
import com.lalit.aiinterviewplatform.entity.User;
import com.lalit.aiinterviewplatform.repository.UserRepository;

/*
 * Authentication Service
 *
 * Purpose:
 * Contains authentication-related business logic.
 *
 * Examples:
 * - User Registration
 * - User Login
 * - Password Validation
 * - JWT Generation (later)
 */
@Service
public class AuthService {

    /*
     * UserRepository is required to perform
     * database operations on the users table.
     */
    private final UserRepository userRepository;

    /*
     * Constructor Injection
     *
     * Spring automatically provides an instance
     * of UserRepository when creating AuthService.
     *
     * This is the recommended dependency injection
     * approach in Spring Boot.
     */
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * Registers a new user.
     *
     * Flow:
     * Check email
     * ↓
     * Create User
     * ↓
     * Save User
     */
    public void registerUser(RegisterRequest request) 
    {

        //Check whether the email already exists
        if(userRepository.existsByEmail(request.getEmail()))

            {
                // Stop registration if eamil already exists
                throw new RuntimeException("Email already registered");
            }

        // Create a new User object
        User user = new User();

        // Copy data from DTO to Entity
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // Every newly registered user gets USER role
        user.setRole("USER");

        // Save user into PostgreSQL
        userRepository.save(user);
    }
}