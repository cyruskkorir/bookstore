package com.cyrus.bookstore;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;









@Controller
public class UserController {

    @Autowired
    private final UserService userService; 
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/user/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list";
    }
    @PutMapping("/user/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        Optional<User> oldUser = userService.findUserById(id);
        if(oldUser.isPresent()){newUser.setId(oldUser.get().getId());}
        return "Updated Successfully";
    }
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/login"; // Redirect to login page
    }
    

    // @GetMapping("/dashboard")
    // public String getDashboard() {
    //     return "dashboard";
    // }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("lg", new Login());
        return "login";
    }
    @PostMapping("/login")
    public String postLogins(@ModelAttribute("lg") Login login, Model model) {
        Optional<User> dbUser = userService.findUserByUserName(login.getUsername());
        if (dbUser.isPresent()) {
            if(passwordEncoder.matches(login.getPassword(), dbUser.get().getPassword())){
                return "redirect:/dashboard";
            }
            // model.addAttribute("error", "Invalid credentials");
        }else{
            // model.addAttribute("error", "User not found");
        }
        return "login";
    }

    
}
