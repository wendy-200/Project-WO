package com.ups.oop.DTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class InvoiceDTO {
    private String id;
    private String name;
    private String date;
    private String totalAmount;
    private String subtotal;


}
