package com.sena.restTutorial.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FormCoffeShop {
    String nama;
    Integer jumProduk;
    String tglTerbentuk;
    Long alamatId;
    List<Long> pemilikId;
}
