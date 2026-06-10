package com.lalit.aiinterviewplatform.dto;

/*
 * Login Response DTO
 *
 * Purpose:
 * Sends login result back to the client.
 *
 * This DTO is NOT a database table.
 */
public class LoginResponse {

    /*
     * Response message.
     *
     * Examples:
     * Login successful
     * Invalid email or password
     */
    private String message;

    /*
     * No-Argument Constructor
     *
     * Required by Spring when creating objects.
     */
    public LoginResponse() {

    }

    /*
     * Parameterized Constructor
     *
     * Allows message assignment while creating object.
     */
    public LoginResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}