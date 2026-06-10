package com.lalit.aiinterviewplatform.dto;

/*
 * Register Request DTO
 *
 * Purpose:
 * Receives registration data sent by the client.
 *
 * Only fields required during registration
 * should be present here.
 *
 * This DTO is NOT a database table.
 */
public class RegisterRequest {

    /*
     * User's name.
     */
    private String name;

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
    public RegisterRequest() {

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
}