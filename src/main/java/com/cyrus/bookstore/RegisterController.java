package com.cyrus.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;


@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/register")
    public String processRegistration(@ModelAttribute("user") @Valid User user,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "register"; // Show form with validation errors
        }
        userService.addUser(user);
        return "redirect:/login"; // Redirect to login page
    }
}

