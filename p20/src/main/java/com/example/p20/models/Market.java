package com.example.p20.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "market")
public class Market {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
