package com.sena.restTutorial.service;

import com.sena.restTutorial.model.CoffeShop;
import com.sena.restTutorial.model.CoffeShopPojo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CoffeShopService {
    List<CoffeShop> findAll();
    Page<CoffeShop> findAllPaging(Integer page, Integer size);
    List<CoffeShop> findByPemilikId(Long id);
    CoffeShopPojo findByIdDetail(Long id);
    CoffeShop findById(Long id);
    CoffeShop update(Long id, CoffeShop coffeShop);
    CoffeShop create(CoffeShop coffeShop);
    void delete(Long id);
}
