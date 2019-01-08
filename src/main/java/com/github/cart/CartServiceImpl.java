package com.github.cart;

import com.github.product.Product;
import com.github.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
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

    @Override
    public void deleteByProduct(Product product, Cart cart) {
        cart.deleteProductList(product);
    }
}
