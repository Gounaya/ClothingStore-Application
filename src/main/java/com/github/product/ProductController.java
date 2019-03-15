package com.github.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Product>> findProducts() {

        List<Product> productList = productService.findAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (productList == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (product == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Product> findProduct(@PathVariable Long id) {

        Product product = productService.find(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (product == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Product productById = productService.find(id);

        if (productById == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        product.setId(id);
        productService.update(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> removeProduct(@PathVariable Long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Product productById = productService.find(id);

        if (productById == null) {
            return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
