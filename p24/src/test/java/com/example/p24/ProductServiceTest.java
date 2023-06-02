package com.example.p24;

import com.example.p24.models.Product;
import com.example.p24.repositories.ProductRepository;
import com.example.p24.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Captor
    private ArgumentCaptor<Product> captor;

    @Test
    void getProducts() {
        Product product = new Product();
        product.setName("prod1");
        Product product1 = new Product();
        product1.setName("prod2");
        Product product2 = new Product();
        product2.setName("prod3");

        Mockito.when(productRepository.findAll()).thenReturn(List.of(product, product1, product2));
        ProductService postService = new ProductService(productRepository);

        Assertions.assertEquals(3, postService.findAll().size());
        Assertions.assertEquals(product.getName(), postService.findAll().get(0).getName());
    }

    @Test
    void save() {
        Product product = new Product();
        product.setName("nameTest");

        ProductService service = new ProductService(productRepository);
        service.save(product);
        Mockito.verify(productRepository).save(captor.capture());
        Product product1 = captor.getValue();

        Assertions.assertEquals("nameTest", product.getName());
    }

}