package com.example.p14.dao;

import com.example.p14.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private ArrayList<Product> products;

    public ProductDAO() {
        products = new ArrayList<>();
        products.add(new Product("hleb", 40));
        products.add(new Product("moloko", 70));
        products.add(new Product("voda", 30));
        products.add(new Product("pivo", 150));
        products.add(new Product("chipsi", 90));
    }

        public List<Product> findAll() {
        return products;
    }

        public void save(Product product) {

            products.add(product);
    }

        public void delete(String name) {
        products.removeIf(it -> it.getName().equals(name));
    }
}
