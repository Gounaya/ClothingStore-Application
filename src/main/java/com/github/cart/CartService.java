package com.github.cart;


import com.github.product.Product;
import com.github.user.User;

import java.util.List;

public interface CartService {
    void save(Cart cart);

    void update(Cart cart);

    Cart find(Long id);

    void delete(Long id);

    List<Cart> findAll();

    void deleteByProduct(Product product, Cart cart);

}
