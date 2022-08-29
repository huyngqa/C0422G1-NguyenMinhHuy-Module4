package com.example.service;

import com.example.model.Product;

import java.util.Map;

public interface ICartService {
    void addProduct(Map<Product, Integer> cart, Product product);

    double getTotal(Map<Product, Integer> cart);

}
