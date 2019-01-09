package com.github.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String addProductGet(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }
    @PostMapping("/add")
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request, BindingResult result){
        if (result.hasErrors()) {
            return "addproduct";
        }


        productService.save(product);
        return "redirect:/";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Product getAllProducts(@PathVariable long id){
        return productService.find(id);
    }

}
