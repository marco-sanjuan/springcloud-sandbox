package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products-service")
public interface StockFeignClient {

    @GetMapping("/products/all")
    List<Product> findAll();

    @GetMapping("/products/{id}")
    Product findOne(@PathVariable Long id);
}
