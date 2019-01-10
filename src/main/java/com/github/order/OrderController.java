package com.github.order;

import com.github.cart.Cart;
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
        Cart cart = (Cart) session.getAttribute("mycart");
        User user = (User) session.getAttribute("user");
        if(cart == null || user == null){
            return "redirect:/";
        }
        Order order = new Order();
        order.setCart(cart);
        order.setUser(user);
        order.setCreated(LocalDateTime.now());
        orderService.save(order);
        Cart newCart = new Cart();
        cartService.save(newCart);
        user.setCart(newCart);
        userService.update(user);
        session.setAttribute("mycart", newCart);
        return "redirect:/";
    }
}
