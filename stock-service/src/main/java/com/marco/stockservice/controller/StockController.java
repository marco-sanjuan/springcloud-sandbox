package com.marco.stockservice.controller;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import com.marco.stockservice.service.StockService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stock/all")
    public List<Stock> findAllStock(){
        return stockService.findAllStock();
    }

    @HystrixCommand(fallbackMethod = "alternativeFindStockByProductId")
    @GetMapping("/stock/product/{id}")
    public Stock findStockByProductId(@PathVariable Long id){
        return stockService.findStockByProductId(id);
    }

    public Stock alternativeFindStockByProductId(Long id){
        Product dummyProduct = new Product();
        dummyProduct.setName("Dummy Product");
        dummyProduct.setId(0L);
        return new Stock(dummyProduct, 0);
    }

}
