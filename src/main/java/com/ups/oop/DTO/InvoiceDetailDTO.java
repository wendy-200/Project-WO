package com.ups.oop.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class InvoiceDetailDTO {
    private Long id;
    private String invoice;
    private String productId;
    private String quantity;
    private Double unitPrice;
    private Double subTotal;

}
