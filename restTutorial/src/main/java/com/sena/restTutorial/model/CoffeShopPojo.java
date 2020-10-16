package com.sena.restTutorial.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CoffeShopPojo {
    private String nama;
    private Alamat alamat;
    private Pemilik pemilik;
    private LocalDate tglTerbentuk;
    private Integer jumProduk;
}
