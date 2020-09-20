package com.sena.restTutorial.repository;

import com.sena.restTutorial.model.Pemilik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PemilikRepository extends JpaRepository<Pemilik, Long> {
}
