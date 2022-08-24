package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findAllProduct(String name, Pageable pageable);

    void save(Product product);

    Product getProductById(int productId);

    void deleteProduct(int productId);
}
