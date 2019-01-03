package com.github.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "homepage";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user){
        User myUser = userService.findByEmail(user.getEmail());
        if(myUser == null){
           return "login";
        }
        System.out.println(myUser.getFirstName());
        return "homepage";
    }
}
