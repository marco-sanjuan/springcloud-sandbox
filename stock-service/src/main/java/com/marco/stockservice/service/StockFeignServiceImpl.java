package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockFeignServiceImpl implements StockService {

    @Autowired
    private StockFeignClient stockFeignClient;

    @Override
    public List<Stock> findAllStock() {
        final List<Product> products = stockFeignClient.findAll();
        return products.stream()
                .map( p -> new Stock(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Stock findStockByProductId(Long id) {
        final Product product = stockFeignClient.findOne(id);
        return new Stock(product, 1);
    }
}
