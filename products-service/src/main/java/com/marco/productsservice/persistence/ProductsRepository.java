package com.marco.productsservice.persistence;

import com.marco.productsservice.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {

}
