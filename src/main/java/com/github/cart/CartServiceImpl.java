package com.github.cart;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void update(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart find(Long id) {
        return cartRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        cartRepository.delete(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }
}
