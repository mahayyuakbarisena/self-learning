package com.sena.restTutorial.service;

import com.sena.restTutorial.model.CoffeShop;

import java.util.List;

public interface CoffeShopService {
    List<CoffeShop> findAll();
    CoffeShop findById(Long id);
    CoffeShop update(Long id, CoffeShop coffeShop);
    CoffeShop create(CoffeShop coffeShop);
    void delete(Long id);
}
