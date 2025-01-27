package com.example.springSecurity.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // ปิด CSRF สำหรับ API (เปิดใช้งานใน production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN")  // เฉพาะ admin เข้าถึง /admin/**
                .requestMatchers("/user/**").hasRole("USER")    // เฉพาะ user เข้าถึง /user/**
                .anyRequest().authenticated()                  // ต้องผ่านการล็อกอินทุก request
            )
            .formLogin(withDefaults())// เปิดใช้งานฟอร์มล็อกอินเริ่มต้น
            .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("admin")
            .roles("ADMIN")
            .build();

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("user")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}

