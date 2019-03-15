package com.github.homepage;


import com.github.product.Product;
import com.github.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class HomePageController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("products")
    List<Product> getProducts(){
        return productService.findAll();
    }

    @RequestMapping("/")
    public String redirectToHomePage(){
        return "homepage";
    }
}
