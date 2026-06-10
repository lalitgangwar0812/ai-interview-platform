package com.lalit.aiinterviewplatform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 * Security Configuration
 *
 * Purpose:
 * Temporarily allow all requests while
 * building and testing APIs.
 *
 * Later this will be replaced with JWT security.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            // Disable CSRF for API testing
            .csrf(csrf -> csrf.disable())

            // Allow all requests without authentication
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll())

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}