package com.sena.simpletransaction.repository;

import com.sena.simpletransaction.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);
}
