package com.ups.oop.DTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class InvoiceDTO {
    private Long id;
    private String Name;
    private String date;
    private Double totalAmount;
    private String subtotal;


}
