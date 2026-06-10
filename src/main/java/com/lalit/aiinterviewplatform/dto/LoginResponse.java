package com.lalit.aiinterviewplatform.dto;

/*
 * Login Response DTO
 *
 * Purpose:
 * Sends JWT token back to the client
 * after successful login.
 *
 * This DTO is NOT a database table.
 */
public class LoginResponse {

    /*
     * JWT Token.
     */
    private String token;

    /*
     * No-Argument Constructor
     */
    public LoginResponse() {

    }

    /*
     * Parameterized Constructor
     */
    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}