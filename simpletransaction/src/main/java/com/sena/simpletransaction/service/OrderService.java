package com.sena.simpletransaction.service;

import com.sena.simpletransaction.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> create(List<Order> orders);
    List<Order> readAll();
    Order readById(Long id);
    void delete(Long id);
}
