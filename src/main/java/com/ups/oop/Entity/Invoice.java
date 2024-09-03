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


public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String date;
    private String totalAmount;
    private String subtotal;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
