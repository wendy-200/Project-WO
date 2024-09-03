package com.ups.oop.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Supplier {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;
    private String supplierName;
    private String supplierAdrress;
    private String phoneNumber;
    private String email;

}
