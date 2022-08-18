package com.exercise.service.impl;

import com.exercise.model.Product;
import com.exercise.repository.IProductRepository;
import com.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAllProduct() {
        return iProductRepository.findAllProduct();
    }

    @Override
    public void addNewProduct(Product product) {
        iProductRepository.addNewProduct(product);
    }

    @Override
    public Product getProductById(int productId) {
        return iProductRepository.getProductById(productId);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        iProductRepository.deleteProduct(productId);
    }

    @Override
    public List<Product> searchProductByName(String searchName) {
        return iProductRepository.searchProductByName(searchName);
    }
}
