package com.ups.oop.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class CustomerDTO {
    private Long id;
    private String CustomerCode;
    private String customername;
    private String address;
    private String phoneNumber;
    private String email;


}
