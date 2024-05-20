package com.cyrus.bookstore;

// import java.io.IOException;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Configuration
public class CustomSecurityConfig {

//     @Bean
//     SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
//         http.authorizeHttpRequests(new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {

//             @Override
//             public void customize(
//                     AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry t) {
//                 t.requestMatchers("/**").hasRole("USER");
//             }
            
//         });
//         return http.build();
//     }

//     private static class RequestLoggingFilter extends OncePerRequestFilter {
//         @Override
//         protected void doFilterInternal(@SuppressWarnings("null") HttpServletRequest request, @SuppressWarnings("null") HttpServletResponse response,
//                                         @SuppressWarnings("null") FilterChain filterChain) throws ServletException, IOException {
//             // Log request details (e.g., path, method, headers)
//             System.out.println("Request received: " + request.getRequestURI());
//             filterChain.doFilter(request, response);
//         }
//     }
}

