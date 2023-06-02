package com.example.p16.controllers;

import com.example.p16.dao.ProductDAO;
import com.example.p16.dto.ProductDTO;
import com.example.p16.models.Product;
import com.example.p16.utils.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductDAO productService;
    private final ProductValidator productValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductDAO productService, ProductValidator productValidator, ModelMapper modelMapper) {
        this.productService = productService;
        this.productValidator = productValidator;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.findAll().stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id")int id) throws ProductNotFoundException {
        productService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody Product product) throws WrongProductDataException{
        productService.save(product);
        return HttpStatus.OK;
    }

    private ProductDTO convertToWorkerDTO(Product product){
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    private Product convertToWorker(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}