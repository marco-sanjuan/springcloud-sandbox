package com.marco.stockservice.service;

import com.marco.stockservice.model.Stock;

import java.util.List;

public interface StockService {

    List<Stock> findAllStock();

    Stock findStockByProductId(Long id);
}
