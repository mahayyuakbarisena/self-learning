package com.sena.restTutorial.repository;

import com.sena.restTutorial.model.Alamat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlamatRepository extends JpaRepository<Alamat, Long> {
    List<Alamat> findAllByKotaAndProvinsi(String kota, String provinsi);
}
