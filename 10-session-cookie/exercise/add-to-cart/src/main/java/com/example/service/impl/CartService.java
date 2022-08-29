package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ICartRepository;
import com.example.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public void addProduct(Map<Product, Integer> cart, Product product) {
        iCartRepository.addProduct(cart, product);
    }

    @Override
    public double getTotal(Map<Product, Integer> cart) {
        return iCartRepository.getTotal(cart);
    }
}
