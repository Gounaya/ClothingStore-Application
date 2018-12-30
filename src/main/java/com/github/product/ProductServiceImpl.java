package com.github.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product find(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
