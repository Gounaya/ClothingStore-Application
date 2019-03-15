package com.github.order;

import java.util.List;

public interface OrderService {
    void save(Order order);

    void update(Order order);

    Order find(Long id);

    void delete(Long id);

    List<Order> findAll();
}
