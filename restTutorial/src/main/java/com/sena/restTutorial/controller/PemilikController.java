package com.sena.restTutorial.controller;

import com.sena.restTutorial.Response;
import com.sena.restTutorial.model.CoffeShop;
import com.sena.restTutorial.model.Pemilik;
import com.sena.restTutorial.service.CoffeShopService;
import com.sena.restTutorial.service.PemilikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/pemilik")
public class PemilikController {
    @Autowired
    PemilikService pemilikService;

    @PostMapping
    ResponseEntity<Response> create (@RequestParam(name = "nama_depan") String namaDepan,
                                     @RequestParam(name = "nama_belakang") String namaBelakang,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "npwp") String npwp) throws UnknownHostException{
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Pemilik pemilik = new Pemilik();
        pemilik.setNamaDepan(namaDepan);
        pemilik.setNamaBelakang(namaBelakang);
        pemilik.setEmail(email);
        pemilik.setNpwp(npwp);
        pemilik.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        pemilik.setCreatedBy(InetAddress.getLocalHost().getHostName());
        pemilik.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        pemilik.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Membuat Data");
        response.setData(pemilikService.create(pemilik));

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
        response.setData(pemilikService.findAll());

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
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Data Berdasarkan Id");
        response.setData(pemilikService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }


    @PutMapping
    ResponseEntity<Response> update (@RequestParam("id") Long id,
                                     @RequestParam(name = "nama_depan") String namaDepan,
                                     @RequestParam(name = "nama_belakang") String namaBelakang,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "npwp") String npwp) throws UnknownHostException{
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Pemilik pemilik = pemilikService.findById(id);
        pemilik.setNamaDepan(namaDepan);
        pemilik.setNamaBelakang(namaBelakang);
        pemilik.setEmail(email);
        pemilik.setNpwp(npwp);
        pemilik.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        pemilik.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Update Data");
        response.setData(pemilikService.update(id, pemilik));

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
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Data Berhasil Dihapus");
        response.setData(pemilikService.findById(id));

        pemilikService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
