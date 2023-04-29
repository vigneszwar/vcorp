package com.vcorp.backendservice.service;

import com.vcorp.backendservice.entity.Product;
import com.vcorp.backendservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void createProducts(List<Product> products) {
        productRepository.saveAll(products);
    }
}
