package com.sena.restTutorial.serviceimpl;

import com.sena.restTutorial.model.CoffeShop;
import com.sena.restTutorial.repository.CoffeShopRepository;
import com.sena.restTutorial.service.CoffeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeShopServiceImpl implements CoffeShopService {
    @Autowired
    CoffeShopRepository coffeShopRepository;

    @Override
    public List<CoffeShop> findAll() {
        return coffeShopRepository.findAll();
    }

    @Override
    public CoffeShop findById(Long id) {
        return coffeShopRepository.findById(id).get();
    }

    @Override
    public CoffeShop update(Long id, CoffeShop coffeShop) {
        coffeShop.getId();
        return coffeShopRepository.save(coffeShop);
    }

    @Override
    public CoffeShop create(CoffeShop coffeShop) {
        return coffeShopRepository.save(coffeShop);
    }

    @Override
    public void delete(Long id) {
        coffeShopRepository.deleteById(id);
    }
}
