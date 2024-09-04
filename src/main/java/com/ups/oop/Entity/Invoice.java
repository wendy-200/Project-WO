package com.ups.oop.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String date;
    private String totalAmount;
    private String subtotal;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    @JoinColumn(name = "invoice")
    private List<Invoice> invoice;
}
