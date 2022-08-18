package com.exercise.service;

import com.exercise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();

    void addNewProduct(Product product);

    Product getProductById(int productId);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    List<Product> searchProductByName(String searchName);
}
