package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockRestTemplateServiceImpl implements StockService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Stock> findAllStock(){
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/products/all", Product[].class));
        return products.stream()
                .map( p -> new Stock(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Stock findStockByProductId(Long id){
        final Product product = restTemplate.getForObject("http://localhost:8001/products/{id}", Product.class, Collections.singletonMap("id", id.toString()));
        return new Stock(product, 1);
    }
}
