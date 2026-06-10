package com.lalit.aiinterviewplatform.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/*
 * JWT Utility Class
 *
 * Purpose:
 * Generate and validate JWT tokens.
 */
@Component
public class JwtUtil {

    /*
     * Secret key used to sign JWT tokens.
     *
     * In production this should come from
     * application.properties or environment variables.
     */
    private static final String SECRET_KEY =
            "mySuperSecretKeyForJwtTokenGeneration123456";

    /*
     * Token validity:
     * 24 hours
     */
    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24;

    /*
     * Creates signing key.
     */
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /*
     * Generate JWT token using email.
     */
    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    /*
     * Extract email from token.
     */
    public String extractEmail(String token) {

        Claims claims = Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    /*
     * Check whether token is valid.
     */
    public boolean isTokenValid(String token) {

        try {

            Jwts.parser()
                    .verifyWith((javax.crypto.SecretKey) getSigningKey())
                    .build()
                    .parseSignedClaims(token);

            return true;

        } catch (Exception exception) {

            return false;
        }
    }
}