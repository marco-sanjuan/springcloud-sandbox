package com.marco.stockservice.controller;

import com.marco.stockservice.model.Stock;
import com.marco.stockservice.service.StockRestTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockRestTemplateServiceImpl stockService;

    @GetMapping("/stock/all")
    public List<Stock> findAllStock(){
        return stockService.findAllStock();
    }

    @GetMapping("/stock/product/{id}")
    public Stock findAllStock(@PathVariable Long id){
        return stockService.findStockByProductId(id);
    }
}
