package com.marco.productsservice.controller;

import com.marco.productsservice.model.Product;
import com.marco.productsservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products/all")
    public List<Product> listAll(){
        return productsService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findOne(@PathVariable Long id){
        final Product producto = productsService.findById(id);
        /*try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return producto;
    }

}
