package com.cyrus.bookstore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
{
        http.authorizeHttpRequests((authorize)->authorize
        .requestMatchers("/user").hasAuthority("USER")
        .anyRequest()
        .authenticated())
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
}
}

