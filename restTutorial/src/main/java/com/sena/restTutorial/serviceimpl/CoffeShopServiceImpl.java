package com.sena.restTutorial.serviceimpl;

import com.sena.restTutorial.model.CoffeShop;
import com.sena.restTutorial.model.CoffeShopPojo;
import com.sena.restTutorial.repository.CoffeShopRepository;
import com.sena.restTutorial.service.CoffeShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<CoffeShop> findAllPaging(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return coffeShopRepository.findAll(pageable);
    }

    @Override
    public CoffeShopPojo findByIdDetail(Long id) {
        CoffeShop coffeShop =  coffeShopRepository.findById(id).get();
        CoffeShopPojo coffeShopPojo = new CoffeShopPojo();
        coffeShopPojo.setAlamat(coffeShop.getAlamat());
        coffeShopPojo.setJumProduk(coffeShop.getJumProduk());
        coffeShopPojo.setNama(coffeShop.getNama());
        coffeShopPojo.setPemilik(coffeShop.getPemilik());
        coffeShopPojo.setTglTerbentuk(coffeShop.getTglTerbentuk());
        return coffeShopPojo;
    }

    @Override
    public List<CoffeShop> findByPemilikId(Long id) {
        return coffeShopRepository.findByPemilikId(id);
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
