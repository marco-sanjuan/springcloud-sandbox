package com.marco.productsservice.controller;

import com.marco.productsservice.model.Product;
import com.marco.productsservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
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

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productsService.save(product);
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product update(@RequestBody Product product, @PathVariable Long id){
        final Product dbProduct = productsService.findById(id);
        dbProduct.setName(product.getName());
        dbProduct.setPrice(product.getPrice());
        dbProduct.setCreatedAt(product.getCreatedAt());
        return productsService.save(dbProduct);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productsService.deleteById(id);
    }
}
