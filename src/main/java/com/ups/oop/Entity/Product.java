package com.ups.oop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String provider;
    private String description;
    private String price;

}
