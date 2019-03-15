package com.github.cart;

import com.github.product.Product;
import com.github.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;

    private Map<Product, Integer> products = new HashMap<>();

    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(Product product) {
        if (this.products.containsKey(product)) {
            this.products.replace(product, this.products.get(product) + 1);
            System.out.println("Dodano product");
        } else {
            this.products.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (this.products.containsKey(product)) {
            if (this.products.get(product) > 1)
                this.products.replace(product, this.products.get(product) - 1);
            else if (this.products.get(product) == 1) {
                this.products.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(this.products);
    }

    @Override
    public BigDecimal getTotal() {
        BigDecimal totalPrice = new BigDecimal(0);
        if(this.products.size() > 0 && this.products != null){
            for (Map.Entry<Product, Integer> pair : products.entrySet()) {
                totalPrice.add(pair.getKey().getPrice());
            }
        }
        return totalPrice;
    }
}
