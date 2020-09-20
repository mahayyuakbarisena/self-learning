package com.sena.restTutorial.service;

import com.sena.restTutorial.model.Alamat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlamatService {
    List<Alamat> findAll();
    List<Alamat> findAllByKotaAndProvinsi(String kota, String Provinsi);
    Alamat getById(Long id);
    Alamat findById(Long id);
    Alamat update(Long id, Alamat alamat);
    Alamat create(Alamat alamat);
    void delete(Long id);
    Page<Alamat> findAllPageable(Pageable pageable);
}
