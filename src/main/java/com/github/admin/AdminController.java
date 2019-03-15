package com.github.admin;

import com.github.product.Product;
import com.github.product.ProductService;
import com.github.user.User;
import com.github.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String adminPage(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null || !user.isAdmin()){
            return "redirect:/";
        }
        return "adminpage";
    }

    @GetMapping("/product/add")
    public String addProductGet(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user == null || !user.isAdmin()){
            return "redirect:/";
        }
        model.addAttribute("product", new Product());
        return "addproduct";
    }

    @PostMapping("/product/add")
    public String addProductPost(@ModelAttribute("product") Product product, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "addproduct";
        }
        User user = (User) session.getAttribute("user");
        if(user == null || !user.isAdmin()){
            return "redirect:/";
        }
        productService.save(product);
        return "redirect:/";
    }
}
