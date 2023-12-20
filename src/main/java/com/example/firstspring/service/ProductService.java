package com.example.firstspring.service;

import com.example.firstspring.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Component //đánh dấu đây là 1 bean ở định dạng bất kỳ
// @Service, @Repository, @Controller: được dùng để đánh dấu bean
// định dạng cụ thể Bean sẽ có tác dụng gì trong dự án
@Service
public class ProductService implements IProductService{

    private final List<Product> products;

    public ProductService() {
        this.products = new ArrayList<>();
        products.add(new Product(1L, "Coca", 7000L, 100L));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findOne(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product, Long id) {
        Product detail = findOne(id);
        if (detail != null) {
            detail.setId(product.getId());
            detail.setName(product.getName());
            detail.setPrice(product.getPrice());
            detail.setQuantity(product.getQuantity());
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product detail = findOne(id);
        if (detail != null) {
            products.remove(detail);
        }
    }
}
