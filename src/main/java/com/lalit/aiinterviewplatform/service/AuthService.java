package com.lalit.aiinterviewplatform.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lalit.aiinterviewplatform.dto.LoginRequest;
import com.lalit.aiinterviewplatform.dto.LoginResponse;
import com.lalit.aiinterviewplatform.dto.RegisterRequest;
import com.lalit.aiinterviewplatform.entity.User;
import com.lalit.aiinterviewplatform.repository.UserRepository;
import com.lalit.aiinterviewplatform.security.JwtUtil;

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
 * - JWT Generation
 */
@Service
public class AuthService {

    /*
     * UserRepository is required to perform
     * database operations on the users table.
     */
    private final UserRepository userRepository;

    /*
     * BCrypt Password Encoder
     *
     * Used to hash passwords before storing
     * them in the database and verify passwords
     * during login.
     */
    private final BCryptPasswordEncoder passwordEncoder;

    /*
     * JWT Utility
     *
     * Used to generate JWT tokens after
     * successful login.
     */
    private final JwtUtil jwtUtil;

    /*
     * Constructor Injection
     *
     * Spring automatically provides the required
     * dependencies when creating AuthService.
     */
    public AuthService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    /*
     * Registers a new user.
     *
     * Flow:
     * Check Email
     * ↓
     * Create User
     * ↓
     * Hash Password
     * ↓
     * Save User
     */
    public void registerUser(RegisterRequest request) {

        // Check whether the email already exists
        if (userRepository.existsByEmail(request.getEmail())) {

            // Stop registration if email already exists
            throw new RuntimeException("Email already registered");
        }

        // Create a new User object
        User user = new User();

        // Copy data from DTO to Entity
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Store BCrypt hash instead of plain password
        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        // Every newly registered user gets USER role
        user.setRole("USER");

        // Save user into PostgreSQL
        userRepository.save(user);
    }

    /*
     * Logs in an existing user.
     *
     * Flow:
     * Find User
     * ↓
     * Verify Password
     * ↓
     * Generate JWT
     * ↓
     * Return Token
     */
    public LoginResponse loginUser(LoginRequest request) {

        // Find user by email
        User user = userRepository.findByEmail(request.getEmail());

        // Check whether user exists
        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }

        // Verify password against BCrypt hash
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid email or password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail());

        // Return token
        return new LoginResponse(token);
    }
}