package com.ups.oop.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class InvoiceDTO {
    private Long id;
    private String customerName;
    private String Date;
    private Double totalAmount;
}
