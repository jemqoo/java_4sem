package com.example.p14.controllers;

import com.example.p14.dao.ProductDAO;
import com.example.p14.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductDAO productDAO;

    @Autowired
    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @PostMapping("/add")
    public HttpStatus add(@RequestBody Product product){
        productDAO.save(product);
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete/{name}")
    public HttpStatus delete(@PathVariable("name") String name) {
        productDAO.delete(name);
        return HttpStatus.OK;
    }
}