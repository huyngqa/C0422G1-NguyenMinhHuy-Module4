package com.exercise.repository.impl;

import com.exercise.model.Product;
import com.exercise.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new LinkedHashMap<>();

    static {
        productMap.put(111, new Product(111, "snack", 1000, "Thơm ngon", "VN"));
        productMap.put(222, new Product(222, "candy", 2000, "Ngọt ngào", "China"));
        productMap.put(333, new Product(333, "cream", 5000, "Mát lạnh", "Thái Lan"));
    }

    @Override
    public List<Product> findAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addNewProduct(Product product) {
        int productId = (int) (Math.random() * 1000);
        product.setProductId(productId);
        productMap.put(product.getProductId(), product);
    }

    @Override
    public Product getProductById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.replace(product.getProductId(), product);
    }

    @Override
    public void deleteProduct(int productId) {
        productMap.remove(productId);
    }

    @Override
    public List<Product> searchProductByName(String searchName) {
        List<Product> products = new ArrayList<>();
        for (Integer i : productMap.keySet()) {
            if (productMap.get(i).getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                products.add(productMap.get(i));
            }
        }
        return products;
    }
}
