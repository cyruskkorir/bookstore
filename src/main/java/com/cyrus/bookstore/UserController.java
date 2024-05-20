package com.cyrus.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;








@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }
    @PutMapping("/users/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        Optional<User> oldUser = userService.findUserById(id);
        if(oldUser.isPresent()){newUser.setId(oldUser.get().getId());}
        return "Updated Successfully";
    }
    @PostMapping("/users/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginUser(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    
    
    @PostMapping("/users/save")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "result";
    }
    
    
}
