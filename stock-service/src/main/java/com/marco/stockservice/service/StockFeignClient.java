package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-service")
public interface StockFeignClient {

    @GetMapping("/products")
    List<Product> findAll();

    @GetMapping("/products/{id}")
    Product findOne(@PathVariable Long id);

    @PostMapping("/products")
    Product saveProduct(@RequestBody Product product);

    @PutMapping("/products/{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable Long id);

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id);
}
