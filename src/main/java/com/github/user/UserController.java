package com.github.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String addNewUser(@ModelAttribute("user") @Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user, Model model, HttpSession session){
        User myUser = userService.findByEmail(user.getEmail());
        if(myUser == null || !myUser.getPassword().equals(user.getPassword())){
            model.addAttribute("msg", "Password or email is incorrect");
            return "login";
        }
        session.setAttribute("user", myUser);
        return "redirect:/";
    }

    @GetMapping("/myaccount")
    public String userInfo() {
        return "myaccount";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
