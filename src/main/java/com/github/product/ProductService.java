package com.github.product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    void update(Product product);

    Product find(Long id);

    void delete(Long id);

    List<Product> findAll();
}
