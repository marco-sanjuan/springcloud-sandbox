package com.marco.stockservice.controller;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import com.marco.stockservice.service.StockService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RefreshScope
@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Value("${example.config.text}")
    private String remoteConfigExample;

    @GetMapping("/stock")
    public List<Stock> findAllStock(){
        return stockService.findAllStock();
    }

    @HystrixCommand(fallbackMethod = "alternativeFindStockByProductId")
    @GetMapping("/stock/product/{id}")
    public Stock findStockByProductId(@PathVariable Long id){
        return stockService.findStockByProductId(id);
    }

    public Stock alternativeFindStockByProductId(Long id){
        final Product dummyProduct = Product.create()
                .withId(0L)
                .withName("Dummy <--------------------------------")
                .withPrice(0.0)
                .withCreatedAt(new Date())
                .build();
        return new Stock(dummyProduct, 0);
    }

    @GetMapping("/stock/config")
    public ResponseEntity<?> printConfiguration(@Value("${server.port}") String port){
        final Map<String, String> configMap = new HashMap<>();
        configMap.put("example", remoteConfigExample);
        configMap.put("port", port);
        return new ResponseEntity<Map<String,String>>(configMap, HttpStatus.OK);
    }

    @PostMapping("/stock/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return stockService.saveProduct(product);
    }

    @PutMapping("/stock/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id){
        return stockService.updateProduct(product, id);
    }

    @DeleteMapping("/stock/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        stockService.deleteProduct(id);
    }

}
