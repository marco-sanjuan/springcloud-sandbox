package com.marco.productsservice.service;

import com.marco.productsservice.model.Product;
import com.marco.productsservice.persistence.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>)productsRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteById(Long productId) {
        if(productId == null){
            return;
        }
        if(productsRepository.findById(productId).isEmpty()){
            return;
        }
        productsRepository.deleteById(productId);
    }
}
