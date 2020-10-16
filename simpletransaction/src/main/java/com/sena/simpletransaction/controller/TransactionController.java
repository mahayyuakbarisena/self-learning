package com.sena.simpletransaction.controller;

import com.sena.simpletransaction.common.controller.BaseController;
import com.sena.simpletransaction.common.responses.BaseResponse;
import com.sena.simpletransaction.entity.Product;
import com.sena.simpletransaction.service.OrderDetailService;
import com.sena.simpletransaction.service.OrderService;
import com.sena.simpletransaction.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionController extends BaseController {
    ProductService productService;
    OrderDetailService orderDetailService;
    OrderService orderService;

    @Autowired
    public TransactionController (ProductService productService, OrderDetailService orderDetailService, OrderService orderService){
        this.orderDetailService = orderDetailService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<BaseResponse> getListProduct() {
        List<Product> listProduct = productService.readAll();
        BaseResponse response = new BaseResponse(200, "Getting all products", listProduct);
        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @PostMapping("/products")
    public ResponseEntity<BaseResponse> createProduct(@RequestParam(name = "name") String name,
                                                      @RequestParam(name = "price") Integer price){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        BaseResponse response = new BaseResponse(200, "Product Created", productService.create(product));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
