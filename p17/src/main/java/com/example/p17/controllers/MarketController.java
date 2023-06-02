package com.example.p17.controllers;

import com.example.p17.dao.MarketDAO;
import com.example.p17.dto.MarketDTO;
import com.example.p17.models.Market;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/markets")
public class MarketController {
    private final MarketDAO marketDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public MarketController(MarketDAO marketDAO, ModelMapper modelMapper) {
        this.marketDAO = marketDAO;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/f")
    public List<MarketDTO> getAll() {
        return marketDAO.findAll().stream().map(this::convertToManufactureDTO).collect(Collectors.toList());
    }


    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable("id")int id) {
        marketDAO.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public HttpStatus add(@RequestBody MarketDTO marketDTO) {
        marketDAO.save(convertToManufacture(marketDTO));
        return HttpStatus.OK;
    }

    private MarketDTO convertToManufactureDTO(Market market) {
        return modelMapper.map(market, MarketDTO.class);
    }

    private Market convertToManufacture(MarketDTO marketDTO) {
        return modelMapper.map(marketDTO, Market.class);
    }
}