package com.marco.stockservice.service;

import com.marco.stockservice.model.Product;
import com.marco.stockservice.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
@Deprecated //we use Feign implementation
public class StockRestTemplateServiceImpl implements StockService {

    public static final String PRODUCTS_SERVICE_BASE_ENDPOINT = "http://products-service/products";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Stock> findAllStock(){
        List<Product> products = Arrays.asList(restTemplate.getForObject(PRODUCTS_SERVICE_BASE_ENDPOINT, Product[].class));
        return products.stream()
                .map( p -> new Stock(p, 1))
                .collect(Collectors.toList());
    }

    @Override
    public Stock findStockByProductId(Long id){
        final Product product = restTemplate.getForObject(PRODUCTS_SERVICE_BASE_ENDPOINT + "/{id}", Product.class, Collections.singletonMap("id", id.toString()));
        return new Stock(product, 1);
    }

    @Override
    public Product saveProduct(Product product) {
        HttpEntity<Product> body = new HttpEntity<>(product);
        final ResponseEntity<Product> response = restTemplate.exchange(PRODUCTS_SERVICE_BASE_ENDPOINT, HttpMethod.POST, body, Product.class);
        return response.getBody();
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        HttpEntity<Product> body = new HttpEntity<>(product);
        final ResponseEntity<Product> response = restTemplate.exchange(PRODUCTS_SERVICE_BASE_ENDPOINT + "/{id}", HttpMethod.PUT, body, Product.class, id);
        return response.getBody();
    }

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete(PRODUCTS_SERVICE_BASE_ENDPOINT + "/{id}", id);
    }
}
