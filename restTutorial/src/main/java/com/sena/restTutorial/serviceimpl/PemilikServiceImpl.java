package com.sena.restTutorial.serviceimpl;

import com.sena.restTutorial.model.Pemilik;
import com.sena.restTutorial.repository.PemilikRepository;
import com.sena.restTutorial.service.PemilikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PemilikServiceImpl implements PemilikService {
    @Autowired
    PemilikRepository pemilikRepository;

    @Override
    public List<Pemilik> findAll() {
        return pemilikRepository.findAll();
    }

    @Override
    public Pemilik findById(Long id) {
        return pemilikRepository.findById(id).get();
    }

    @Override
    public Pemilik update(Long id, Pemilik pemilik) {
        pemilik.getId();
        return pemilikRepository.save(pemilik);
    }

    @Override
    public Pemilik create(Pemilik pemilik) {
        return pemilikRepository.save(pemilik);
    }

    @Override
    public Pemilik getById(Long id) {
        return pemilikRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        pemilikRepository.deleteById(id);
    }
}
