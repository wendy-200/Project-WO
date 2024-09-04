package com.ups.oop.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ProductDTO {
        private String id;
        private String name;
        private String provider;
        private String description;
        private String price;

}
