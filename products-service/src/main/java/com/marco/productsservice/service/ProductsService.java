package com.marco.productsservice.service;

import com.marco.productsservice.model.Product;

import java.util.List;

public interface ProductsService {

    List<Product> findAll();

    Product findById(Long id);
}
