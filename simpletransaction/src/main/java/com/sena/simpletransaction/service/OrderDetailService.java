package com.sena.simpletransaction.service;

import com.sena.simpletransaction.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail create(OrderDetail orderDetail);
    List<OrderDetail> readAll();
    OrderDetail readById(Long id);
    void delete(Long id);
}
