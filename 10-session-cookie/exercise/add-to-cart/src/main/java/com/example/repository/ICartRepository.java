package com.example.repository;

import com.example.model.Product;

import java.util.Map;

public interface ICartRepository {
    void addProduct(Map<Product, Integer> cart, Product product);

    double getTotal(Map<Product, Integer> cart);
}
