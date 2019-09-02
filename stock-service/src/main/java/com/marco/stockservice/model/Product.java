package com.marco.stockservice.model;

import java.util.Date;

public class Product {

    public Product() {
    }

    Product(Long id, String name, Double price, Date createdAt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    private Long id;

    private String name;

    private Double price;

    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




    public static ProductBuilder create(){
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        public StepName withId(Long id){
            return name -> price -> createdAt -> () -> new Product(id, name, price, createdAt);
        }

        public interface StepName{
            StepPrice withName(String name);
        }

        public interface StepPrice {
            StepCreatedAt withPrice(Double price);
        }

        public interface StepCreatedAt {
            StepBuild withCreatedAt(Date createdAt);
        }

        public interface StepBuild {
            Product build();
        }
    }
}
