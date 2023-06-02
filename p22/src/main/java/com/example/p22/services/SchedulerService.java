package com.example.p22.services;

import com.example.p22.dto.ProductDTO;
import com.example.p22.models.Product;
import com.example.p22.models.Market;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
@ManagedResource(description = "Scheduler service bean")
@EnableScheduling
public class SchedulerService {
    private final MarketService marketService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    private final String DIRECTORY;

    @Autowired
    public SchedulerService(MarketService marketService, ProductService productService,
                            ModelMapper modelMapper) {
        this.marketService = marketService;
        this.productService = productService;
        this.modelMapper = modelMapper;
        DIRECTORY = "src/backup";
    }

    @Scheduled(fixedRate = 200)
    public void scheduledTask() throws IOException {
        System.out.println("-= Backup saved!");

        List<Market> manufactures = marketService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        File directory = new File(DIRECTORY);
        for(File x : Objects.requireNonNull(directory.listFiles()))
            x.delete();

        for(Market x : manufactures) {
            String name = "Market " + x.getId() + ".txt";
            File file = new File(directory.getAbsolutePath() + "/" + name);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(mapper.writeValueAsString(x));
            fileWriter.flush();
        }

        List<Product> workers = productService.findAll();
        for(Product x : workers) {
            String name = "Product " + x.getId() + ".txt";
            File file = new File(directory.getAbsolutePath() + "/" + name);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            fileWriter.write(mapper.writeValueAsString(convertToPostDTO(x)));
            fileWriter.flush();
        }
    }

    private ProductDTO convertToPostDTO(Product worker) {
        ProductDTO workerDTO = modelMapper.map(worker, ProductDTO.class);
        return workerDTO;
    }
}