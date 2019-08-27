package com.marco.productsservice.controller;

import com.marco.productsservice.model.Product;
import com.marco.productsservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/products/all")
    public List<Product> listAll(){
        return productsService.findAll().stream()
                .peek(p -> p.setPort(port))
                .collect(toList());
    }

    @GetMapping("/products/{id}")
    public Product findOne(@PathVariable Long id){
        final Product product = productsService.findById(id);
        product.setPort(port);
        return product;
    }

}
