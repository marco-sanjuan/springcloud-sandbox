package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> findAllStock();

    Stock findStockByProductId(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product, Long id);

    void deleteProduct(Long id);
}
