package com.ups.oop.Entity;


import jakarta.persistence.ManyToOne;
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


public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "InvoiceDetail_id",nullable = false)
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "Product_id",nullable = false)
    private Product productId;
    private Integer quantity;
    private Double price;

}
