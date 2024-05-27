package com.cyrus.bookstore;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent()){
            User usr = user.get();
            return org.springframework.security.core.userdetails.User
            .withUsername(usr.getUserName())
            .password(usr.getPassword())
            // .roles("USER")
            .build();
                
        }
        throw new UsernameNotFoundException("No user named "+username);

}
}