package com.lalit.aiinterviewplatform.repository;
// This file belongs to the repository package.
// Repository classes are responsible for communicating with the database.

import org.springframework.data.jpa.repository.JpaRepository;
// Imports JpaRepository provided by Spring Data JPA.
// JpaRepository gives ready-made database operations like:
// save(), findById(), findAll(), deleteById(), etc.

import com.lalit.aiinterviewplatform.entity.User;
// Imports the User entity because this repository
// will perform database operations on the users table.

/*
 * User Repository
 *
 * Purpose:
 * Acts as the data access layer for the User entity.
 *
 * Spring Data JPA will automatically create the implementation
 * at runtime, so no class implementation is required.
 *
 * This repository allows operations such as:
 * - Save a user
 * - Find a user by ID
 * - Get all users
 * - Delete a user
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /*
     * Checks whether a user already exists
     * with the given email address.
     *
     * Spring Data JPA automatically generates
     * the SQL query for this method.
     *
     * Example:
     * existsByEmail("lalit@gmail.com")
     */
    boolean existsByEmail(String email);

    /*
     * By extending JpaRepository, Spring automatically provides:
     *
     * save(user)
     * findById(id)
     * findAll()
     * deleteById(id)
     *
     * More custom methods can be added later.
     *
     * Example:
     * Optional<User> findByEmail(String email);
     */

    User findByEmail(String email);

}