package com.cyrus.bookstore;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<User> user = userRepository.findByUserName(username);
        if(user.isPresent()){
            User currentUser = user.get();
            return new UserDetails() {

                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
                }

                @Override
                public String getPassword() {
                    // TODO Auto-generated method stub

                    return currentUser.getPassword();
                }

                @Override
                public String getUsername() {
                    // TODO Auto-generated method stub
                    return currentUser.getUserName();
                }

                @Override
                public boolean isAccountNonExpired() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
                }

                @Override
                public boolean isAccountNonLocked() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isAccountNonLocked'");
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isCredentialsNonExpired'");
                }

                @Override
                public boolean isEnabled() {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'isEnabled'");
                }
                
            };
        }
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }

}
