package com.lalit.aiinterviewplatform.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * User Entity
 *
 * Purpose:
 * Represents a user of the AI Interview Platform.
 *
 * Hibernate will use this class to create and manage
 * the "users" table inside PostgreSQL.
 */
@Entity // Marks this class as a database entity
@Table(name = "users") // Maps this entity to the users table
public class User {

    /*
     * Primary Key
     *
     * Every user needs a unique identifier.
     * PostgreSQL will automatically generate IDs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * User's display name.
     *
     * Example:
     * Lalit Gangwar
     */
    private String name;

    /*
     * User's email address.
     *
     * Used for login.
     *
     * unique = true
     * Prevents duplicate email addresses.
     *
     * nullable = false
     * Email is required.
     */
    @Column(unique = true, nullable = false)
    private String email;

    /*
     * User's password.
     *
     * Later this will be stored as a BCrypt hash,
     * not as plain text.
     */
    private String password;

    /*
     * User role.
     *
     * Examples:
     * USER
     * ADMIN
     *
     * For MVP, all registered users will be USER.
     */
    private String role;

    /*
     * Stores when the account was created.
     *
     * Hibernate automatically sets this value
     * when a new user is saved.
     */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /*
     * No-Argument Constructor
     *
     * Required by JPA/Hibernate.
     * Hibernate uses it internally when creating
     * objects from database records.
     */
    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}