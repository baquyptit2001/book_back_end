package com.example.backend.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class LibrarySecurityConfig {
    private static final String[] SECURED_URLs = {
            "/books/**"
    };

    private static final String[] UNSECURED_URLs = {
            "/books/all",
            "/books/book/{id}",
            "/users/**",
    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UNSECURED_URLs)
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(SECURED_URLs).
                hasAuthority("ADMIN").anyRequest()
                .authenticated().and().formLogin().and().build();
    }
}
