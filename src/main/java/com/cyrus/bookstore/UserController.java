package com.cyrus.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;








@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/user")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }
    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User newUser = new User(user.getEmail(), user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        Optional<User> oldUser = userService.findUserById(id);
        if(oldUser.isPresent()){newUser.setId(oldUser.get().getId());}
        return "Updated Successfully";
    }
    @GetMapping("/user/register")
    public String showRegistrationForm(Model model, User user) {
        model.addAttribute("user", new User(user.getEmail(), user.getPassword()));
        return "register";
    }

    @PostMapping("/user/register")
    public String processRegistration(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register"; // Show form with validation errors
        }
        userService.addUser(user);
        return "redirect:/loginuser"; // Redirect to login page
    }
    @GetMapping("user/login")
    public String loginUser(Model model, @RequestBody User user) {
        model.addAttribute("user", new User(user.getEmail(), user.getPassword()));
        return "user/login";
    }
    // @PostMapping("/dashboard")
    // public String postLogins(@RequestBody User user, BindingResult bindingResult) {
    //     if (bindingResult.hasErrors()) {
    //         return "loginuser";   
    //     }
    //     return "dashboard";
    // }

    @GetMapping("user/dashboard")
    public String getDashboard() {
        return "dashboard";
    }
    
    
    
    @PostMapping("/admin/save")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "result";
    }
    
    
}
