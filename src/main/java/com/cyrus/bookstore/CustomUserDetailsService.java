package com.cyrus.bookstore;

import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  {
    // @Autowired
    // private UserService userService;

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     User user = userService.findUserByEmail(email)
    //             .orElseThrow(() -> new UsernameNotFoundException("Email not registered: " + email));

    //     // Create UserDetails object (e.g., using Spring Security's User class)
    //     return new org.springframework.security.core.userdetails.User(
    //             user.getEmail(),
    //             user.getPassword(),
    //             Collections.emptyList());
    // }
}

