package com.github.user;

import com.github.cart.Cart;
import com.github.cart.CartService;
import com.github.utils.MailSender;

import org.apache.commons.lang3.RandomStringUtils;
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
    @Autowired
    private CartService cartService;

    @GetMapping("/register")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(@ModelAttribute @Valid User user, BindingResult result, Model model, HttpSession session){
        if (result.hasErrors()) {
            return "register";
        }
        Cart myCart = (Cart) session.getAttribute("mycart");

        if(myCart == null){
            myCart = new Cart();
            cartService.save(myCart);
        }
        user.setCart(myCart);
        session.setAttribute("mycart", myCart);

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/register/{token}")
    public String registerUser(@PathVariable String token){
        User user = userService.findByRegisterToken(token);
        if(user == null){
            return "redirect:/";
        }
        if(user.getRegisterToken().equals(token)){
            // todo message passed
            user.setRegister(true);
            userService.update(user);
        }
        return "redirect:/";
    }
    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") User user, Model model, HttpSession session){

        Cart myCart = (Cart) session.getAttribute("mycart");

        if(myCart != null){
            session.removeAttribute("mycart");
        }

        User myUser = userService.findUserByEmail(user.getEmail());
        if(myUser == null || !myUser.getPassword().equals(user.getPassword())){
            model.addAttribute("msg", "Password or email is incorrect");
            return "login";
        }
        // todo update listproduct, old + after login
        session.setAttribute("mycart", user.getCart());
        session.setAttribute("user", myUser);
        //session.setMaxInactiveInterval(-1);
        return "redirect:/";
    }

    @GetMapping("/myaccount")
    public String userInfo() {
        return "myaccount";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("mycart");
        return "redirect:/";
    }
}
