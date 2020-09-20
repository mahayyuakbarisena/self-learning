package com.sena.restTutorial.controller;

import com.sena.restTutorial.Response;
import com.sena.restTutorial.model.Alamat;
import com.sena.restTutorial.model.CoffeShop;
import com.sena.restTutorial.model.Pemilik;
import com.sena.restTutorial.service.AlamatService;
import com.sena.restTutorial.service.CoffeShopService;
import com.sena.restTutorial.service.PemilikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/coffeshop")
public class CoffeShopController {
    @Autowired
    CoffeShopService coffeShopService;

    @Autowired
    AlamatService alamatService;

    @Autowired
    PemilikService pemilikService;

    @PostMapping
    ResponseEntity<Response> create (@RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "jum_produk") Integer jumProduk,
                                     @RequestParam(name = "tgl_terbentuk") String tglTerbentuk,
                                     @RequestParam(name = "alamat_id") Long alamatId,
                                     @RequestParam(name = "pemilik_id") Long pemilikId) throws UnknownHostException {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        CoffeShop coffeShop = new CoffeShop();
        Alamat alamat = alamatService.findById(alamatId);
        Pemilik pemilik = pemilikService.findById(pemilikId);
        coffeShop.setNama(nama);
        coffeShop.setJumProduk(jumProduk);
        LocalDate tanggalTerbentuk = LocalDate.parse(tglTerbentuk);
        coffeShop.setTglTerbentuk(tanggalTerbentuk);
        coffeShop.setAlamat(alamat);
        coffeShop.setPemilik(pemilik);
        coffeShop.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        coffeShop.setCreatedBy(InetAddress.getLocalHost().getHostName());
        coffeShop.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        coffeShop.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Membuat Data");
        response.setData(coffeShopService.create(coffeShop));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping
    ResponseEntity<Response> readAll(){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data");
        response.setData(coffeShopService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{id}")
    ResponseEntity<Response> readById(@PathVariable(value = "id") Long id){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Data Berdasarkan Id");
        response.setData(coffeShopService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


    @PutMapping
    ResponseEntity<Response> update (@RequestParam(name = "id") Long id,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "jum_produk") Integer jumProduk,
                                     @RequestParam(name = "tgl_terbentuk") String tglTerbentuk,
                                     @RequestParam(name = "alamat_id") Long alamatId,
                                     @RequestParam(name = "pemilik_id") Long pemilikId) throws UnknownHostException {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        CoffeShop coffeShop = coffeShopService.findById(id);
        Alamat alamat = alamatService.findById(alamatId);
        Pemilik pemilik = pemilikService.findById(pemilikId);
        coffeShop.setNama(nama);
        coffeShop.setJumProduk(jumProduk);
        LocalDate tanggalTerbentuk = LocalDate.parse(tglTerbentuk);
        coffeShop.setTglTerbentuk(tanggalTerbentuk);
        coffeShop.setAlamat(alamat);
        coffeShop.setPemilik(pemilik);
        coffeShop.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        coffeShop.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Update Data");
        response.setData(coffeShopService.update(id, coffeShop));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping
    ResponseEntity<Response> deleteById(@RequestParam(value = "id") Long id){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Data Berhasil Dihapus");
        response.setData(coffeShopService.findById(id));

        coffeShopService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
