package com.sena.simpletransaction.serviceimpl;

import com.sena.simpletransaction.common.exception.ResourceNotFoundException;
import com.sena.simpletransaction.entity.Product;
import com.sena.simpletransaction.repository.ProductRepository;
import com.sena.simpletransaction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> readByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Product update(Long id, Product newProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: "+ id + " not found"));
        product.setName(newProduct.getName());
        product.setPrice(newProduct.getPrice());
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
