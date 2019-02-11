package com.github.cart;



import com.github.product.Product;
import com.github.product.ProductService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/info")
    public String myCart(Model model){
        return "mycart";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Product,Integer>> addProductCart(@PathVariable Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Product product = productService.find(id);

        if(product == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        cartService.addProduct(product);
        Map<Product,Integer> cart = cartService.getProductsInCart();
        System.out.println(cart.toString());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
    @SuppressWarnings("Duplicates")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<Product, Integer>> findCart(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<Product,Integer> cart = cartService.getProductsInCart();

        if(cart == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removeProduct(@PathVariable Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Product product = productService.find(id);

        if(product == null){
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        cartService.removeProduct(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
