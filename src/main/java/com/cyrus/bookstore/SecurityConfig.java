package com.cyrus.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
{
        http
        .authorizeHttpRequests((requests) -> requests
        .requestMatchers("/", "/login", "/home", "/register", "/books").permitAll()
        .requestMatchers("/admin/").hasRole("ADMIN").anyRequest().authenticated()
        )
        .formLogin((form) -> form
        // .loginPage("/login")
        .defaultSuccessUrl("/dashboard")
        .permitAll()
        )
        .logout((logout) -> logout.permitAll());

        return http.build();
}
}

