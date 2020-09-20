package com.sena.restTutorial.service;

import com.sena.restTutorial.model.Pemilik;
import java.util.List;

public interface PemilikService {
    List<Pemilik> findAll();
    Pemilik findById(Long id);
    Pemilik getById(Long id);
    Pemilik update(Long id, Pemilik pemilik);
    Pemilik create(Pemilik pemilik);
    void delete(Long id);
}
