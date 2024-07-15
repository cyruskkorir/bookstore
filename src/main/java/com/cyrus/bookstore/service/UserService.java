package com.cyrus.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyrus.bookstore.UserRepository;
import com.cyrus.bookstore.model.User;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> findUserByUserName(String userName){
        return userRepository.findByUsername(userName);
    }
    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    public void addUser(User user){
        userRepository.save(user);
    }

}
