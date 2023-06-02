package com.example.p22.controllers;

import com.example.p22.services.EmailService;
import com.example.p22.services.ProductService;
import com.example.p22.dto.ProductDTO;
import com.example.p22.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    @Autowired
    public ProductController(ProductService productService, ModelMapper modelMapper, EmailService emailService) {
        this.productService = productService;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.findAll().stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id")int id){
        productService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody Product product){
        productService.save(product);
//        emailService.sendNotification(product);
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