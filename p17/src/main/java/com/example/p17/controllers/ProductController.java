package com.example.p17.controllers;

import com.example.p17.dao.ProductDAO;
import com.example.p17.dto.ProductDTO;
import com.example.p17.models.Product;
import com.example.p17.utils.*;
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

    @GetMapping("/without")
    public List<ProductDTO> getWithout() {
        List<Product> posts = productService.getWorkersWithouManifacture();
        return posts.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @GetMapping("/text")
    public ProductDTO findByName(@RequestParam("name")String name) {
        Product post = productService.findByText(name);
        return convertToWorkerDTO(post);
    }

    @GetMapping("/with")
    public List<ProductDTO> getWith() {
        List<Product> posts = productService.getWithUser();
        return posts.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @GetMapping("/gt/{id}")
    public List<ProductDTO> greaterThan(@PathVariable("id")int id) {
        List<Product> posts = productService.greaterThanById(id);
        return posts.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    private ProductDTO convertToWorkerDTO(Product product){
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    private Product convertToWorker(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}