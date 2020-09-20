package com.sena.restTutorial.controller;


import com.sena.restTutorial.Response;
import com.sena.restTutorial.model.Alamat;
import com.sena.restTutorial.service.AlamatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;


@RestController
@RequestMapping("/api/alamat")
public class AlamatController {
    @Autowired
    AlamatService alamatService;

    @PostMapping
    ResponseEntity<Response> create (@RequestParam(name = "jalan") String jalan,
                                     @RequestParam(name = "kota") String kota,
                                     @RequestParam(name = "provinsi") String provinsi,
                                     @RequestParam(name = "kode_pos") int kodePos) throws UnknownHostException {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Alamat alamat = new Alamat();
        alamat.setJalan(jalan);
        alamat.setKota(kota);
        alamat.setProvinsi(provinsi);
        alamat.setKodePos(kodePos);
        alamat.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        alamat.setCreatedBy(InetAddress.getLocalHost().getHostName());
        alamat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        alamat.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Membuat Data");
        response.setData(alamatService.create(alamat));

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
        response.setData(alamatService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/paging")
    ResponseEntity<Response> readAllPageable(@RequestParam(name = "page") Integer page,
                                             @RequestParam(name = "size") Integer size){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Pageable pageable = PageRequest.of(page, size);

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Seluruh Data");
        response.setData(alamatService.findAllPageable(pageable));

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
        response.setData(alamatService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/{kota}/{provinsi}")
    ResponseEntity<Response> readById(@PathVariable(value = "kota") String kota,
                                      @PathVariable(value = "provinsi") String provinsi){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() +"."+ nameofCurrMethod);
        response.setMessage("Berhasil Menampilkan Data Berdasarkan Kota dan Provinsi");
        response.setData(alamatService.findAllByKotaAndProvinsi(kota, provinsi));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping
    ResponseEntity<Response> update (@RequestParam(name = "id") Long id,
                                     @RequestParam(name = "jalan") String jalan,
                                     @RequestParam(name = "kota") String kota,
                                     @RequestParam(name = "provinsi") String provinsi,
                                     @RequestParam(name = "kode_pos") int kodePos) throws UnknownHostException {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Alamat alamat = alamatService.findById(id);
        alamat.setJalan(jalan);
        alamat.setKota(kota);
        alamat.setProvinsi(provinsi);
        alamat.setKodePos(kodePos);
        alamat.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        alamat.setUpdatedBy(InetAddress.getLocalHost().getHostName());

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Update Data");
        response.setData(alamatService.update(id, alamat));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById(@PathVariable(value = "id") Long id){
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Data Berhasil Dihapus");
        response.setData(alamatService.findById(id));

        alamatService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
