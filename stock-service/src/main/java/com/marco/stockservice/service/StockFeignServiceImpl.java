package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
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

    @Override
    public Product saveProduct(Product product) {
        return stockFeignClient.saveProduct(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        return stockFeignClient.updateProduct(product, id);
    }

    @Override
    public void deleteProduct(Long id) {
        stockFeignClient.deleteProduct(id);
    }
}
