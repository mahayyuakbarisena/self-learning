package com.sena.simpletransaction.serviceimpl;

import com.sena.simpletransaction.entity.Order;
import com.sena.simpletransaction.repository.OrderRepository;
import com.sena.simpletransaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> create(List<Order> orders) {
        return orderRepository.saveAll(orders);
    }

    @Override
    public List<Order> readAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order readById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
