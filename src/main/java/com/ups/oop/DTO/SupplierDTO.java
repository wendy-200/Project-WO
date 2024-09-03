package com.ups.oop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SupplierDTO {
    private Long id;
    private String supplierAddress;
    private String phoneNumber;
    private String email;
}
