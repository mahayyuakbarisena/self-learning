package com.sena.simpletransaction.service;

import com.sena.simpletransaction.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> readAll();
    List<Product> readByName(String name);
    Product update(Long id, Product newProduct);
    void delete(Long id);
}
