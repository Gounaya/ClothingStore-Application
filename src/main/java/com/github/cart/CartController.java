package com.github.cart;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.product.Product;
import com.github.product.ProductService;
import com.github.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("/info")
    public String myCart(Model model, HttpSession session){
/*        Cart cart ;
        if(cart == null){
            // todo  ....
        }
        List<Product> myProducts = cart.getProductList();
        model.addAttribute("products", myProducts);*/

        return "mycart";
    }
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addProductCart(HttpSession session){

        Product product = productService.find(1L);
        Cart myCart = (Cart) session.getAttribute("mycart");
        User user = (User) session.getAttribute("user");
        if(myCart == null){
            myCart = new Cart();
            cartService.save(myCart);
            session.setAttribute("mycart", myCart);
        }
        myCart.updateProductList(product);
        cartService.update(myCart);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<String> addProductCart(@PathVariable Long id) {


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Product product = productService.find(id);

        if (product == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/${cid}/product/${uid}",method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@RequestBody String json){

        ObjectMapper mapper = new ObjectMapper();

        Product objectProduct = null;
        try {
            objectProduct = mapper.readValue(json, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (objectProduct == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }

        Product product = productService.find(objectProduct.getId());
        Cart cart = cartService.find(product.getCart().getId());

        if (product == null || cart == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        cartService.deleteByProduct(product, cart);
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
}
