package com.example.p24.services;

import com.example.p24.models.Product;
import com.example.p24.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        log.info("Products displayed");
        return productRepository.findAll();
    }

    @Transactional
    public void save(Product product) {
        log.info("Product with id:{product.getID()} saved");
        productRepository.save(product);
    }

    @Transactional
    public void delete(int id) {
        log.info("Product with id:{id} deleted");
        productRepository.deleteById(id);
    }

}
