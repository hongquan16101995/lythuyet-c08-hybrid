package com.example.firstspring.service;

import com.example.firstspring.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findOne(Long id);

    void create(Product product);

    void update(Product product, Long id);

    void deleteProduct(Long id);
}
