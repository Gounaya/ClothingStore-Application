package com.github.cart;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.product.Product;
import com.github.product.ProductService;
import com.github.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/info")
    public String myCart(Model model, HttpSession session){
        return "mycart";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> addProductCart(HttpSession session){
        Cart cart = (Cart) session.getAttribute("mycart");

        if(cart == null){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> addProductCart(@PathVariable Long id, HttpSession session){

        Product product = productService.find(id);
        Cart cart = (Cart) session.getAttribute("mycart");

        if(product == null){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        if(cart == null){
            cart = new Cart();
            cartService.save(cart);
            session.setAttribute("mycart", cart);
        }
        List<Product> products = cart.getProductList();
        products.add(product);
        cart.setProductList(products);
        cartService.update(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }


    @RequestMapping(value = "/{cid}/product/{pid}",method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long cid, @PathVariable Long pid){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Cart cart = cartService.find(cid);
        Product product = productService.find(pid);

        if (product == null || cart == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        List<Product> productList = cart.getProductList();
        productList.remove(product);
        cart.setProductList(productList);
        cartService.update(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
}
