package com.sena.restTutorial.repository;

import com.sena.restTutorial.model.CoffeShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeShopRepository extends JpaRepository<CoffeShop, Long> {
    List<CoffeShop> findByPemilikId(Long pemilikId);
}
