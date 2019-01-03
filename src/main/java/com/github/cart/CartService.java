package com.github.cart;

import java.util.List;

public interface CartService {
    void save(Cart cart);

    void update(Cart cart);

    Cart find(Long id);

    void delete(Long id);

    List<Cart> findAll();
}
