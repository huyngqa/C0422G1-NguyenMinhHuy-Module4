package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.ICartRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CartRepository implements ICartRepository {

    @Override
    public void addProduct(Map<Product,Integer> cart, Product product) {
        if (cart.containsKey(product)){
            cart.put(product,cart.get(product) + 1);
        }else {
            cart.put(product,1);
        }
    }

    @Override
    public double getTotal(Map<Product,Integer> cart) {
        double total = 0;
        for (Product p : cart.keySet()){
            total += p.getPrice() * cart.get(p);
        }
        return total;
    }
}
