package com.cyrus.bookstore.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.cyrus.bookstore.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;
    

    //  @GetMapping("/login")
    // public String showLoginPage(Model model) {
    //     model.addAttribute("log", new Login());
    //     return "login";
    // }
    
    // @PostMapping("/login")
    // public String postLogins(@ModelAttribute("log") Login login, Model model) {
    //     Optional<User> dbUser = userService.findUserByUserName(login.getUsername());
    //     if (dbUser.isPresent()) {
    //         if(passwordEncoder.matches(login.getPassword(), dbUser.get().getPassword())){
    //             return "redirect:/dashboard";
    //         }
    //         model.addAttribute("error", "Invalid credentials");
    //     }else{
    //         model.addAttribute("error", "User not found");
    //     }
    //     return "login";
    // }
}
