package com.CAMS.app.Config;

import com.CAMS.app.Models.DAO.Services.CustomUserDetailsService; // Ensure this import is correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; // Import this
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService; // Keep this import
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // These components are required for the JWT authentication flow
    @Autowired
    private CustomUserDetailsService customUserDetailsService; // This is your database-backed service

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // This bean tells Spring Security to use your CustomUserDetailsService for
    // authentication
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        // This will automatically use the CustomUserDetailsService that is @Autowired
        // or any UserDetailsService bean available in the context.
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      
     *      
     *         .csrf(csrf -> csrf.disable())
     * 
     * 
     * onfigure request a
     * horizeHttpRequests(auth -> auth
     * // Allow public
     * .requestM
     *         // Require ADMIN role for all requests to
     *  
                 // All other requests must be authenticated
                .anyRequest().authenticated()
            )

            
                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntry
                

                .sessionManagement(sess -> sess.sessionC
                
                        ur custom JWT filter before the default Spring Security fil
                        FilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                        
                        
                        is needed to make the H2 console work within a
                        ders(headers -> headers.frameOptions(frameO
                        r

                
                

                
                