package com.sena.restTutorial.serviceimpl;

import com.sena.restTutorial.model.Alamat;
import com.sena.restTutorial.repository.AlamatRepository;
import com.sena.restTutorial.service.AlamatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlamatServiceImpl implements AlamatService {
    @Autowired
    AlamatRepository alamatRepository;

    @Override
    public List<Alamat> findAll() {
        return alamatRepository.findAll();
    }

    @Override
    public Page<Alamat> findAllPageable(Pageable pageable) {
        return alamatRepository.findAll(pageable);
    }

    @Override
    public Alamat findById(Long id) {
        return alamatRepository.findById(id).get();
    }

    @Override
    public Alamat update(Long id, Alamat alamat) {
        return alamatRepository.save(alamat);
    }

    @Override
    public Alamat create(Alamat alamat) {
        return alamatRepository.save(alamat);
    }

    @Override
    public void delete(Long id) {
        alamatRepository.deleteById(id);
    }

    @Override
    public List<Alamat> findAllByKotaAndProvinsi(String kota, String provinsi) {
        return alamatRepository.findAllByKotaAndProvinsi(kota, provinsi);
    }

    @Override
    public Alamat getById(Long id) {
        return alamatRepository.getOne(id);
    }
}
