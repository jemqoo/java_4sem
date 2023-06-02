package com.example.p23.dto;

import com.example.p23.models.Market;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ProductDTO {
    private int ID;
    private String name;
    private int price;

    private Market market;
}
