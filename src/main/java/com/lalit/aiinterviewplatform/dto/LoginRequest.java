package com.lalit.aiinterviewplatform.dto;

/*
 * Login Request DTO
 *
 * Purpose:
 * Receives login data sent by the client.
 *
 * This DTO is NOT a database table.
 */
public class LoginRequest {

    /*
     * User's email address.
     */
    private String email;

    /*
     * User's password.
     */
    private String password;

    /*
     * No-Argument Constructor
     *
     * Required for Spring to create objects
     * from incoming JSON requests.
     */
    public LoginRequest() {

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
}