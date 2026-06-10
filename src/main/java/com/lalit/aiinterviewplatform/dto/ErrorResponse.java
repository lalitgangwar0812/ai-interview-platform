package com.lalit.aiinterviewplatform.dto;

/*
 * Error Response DTO
 *
 * Purpose:
 * Sends error information back to the client.
 */
public class ErrorResponse {

    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}