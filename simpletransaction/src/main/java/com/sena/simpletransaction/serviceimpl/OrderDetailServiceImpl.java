package com.sena.simpletransaction.serviceimpl;

import com.sena.simpletransaction.entity.OrderDetail;
import com.sena.simpletransaction.repository.OrderDetailRepository;
import com.sena.simpletransaction.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> readAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail readById(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
