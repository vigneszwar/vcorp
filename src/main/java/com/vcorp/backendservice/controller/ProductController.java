package com.vcorp.backendservice.controller;

import com.vcorp.backendservice.entity.Product;
import com.vcorp.backendservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.accepted().body(productService.getProducts());
    }

    @GetMapping("/init")
    public ResponseEntity<String> initializeProducts() {
        ArrayList<Product> ar = new ArrayList<>();
        ar.add(Product.builder().name("candy").price(10.0).build());
        productService.createProducts(ar);
        return ResponseEntity.ok().body("Created");
    }
}
