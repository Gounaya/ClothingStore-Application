package com.github.order;

import com.github.cart.CartService;
import com.github.user.User;
import com.github.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class OrderController {
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping("/order/finish/")
    public String finish(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "redirect:/";
        }
        Order order = new Order();
        order.setUser(user);
        order.setCreated(LocalDateTime.now());
        orderService.save(order);
        userService.update(user);
        return "redirect:/";
    }
}
