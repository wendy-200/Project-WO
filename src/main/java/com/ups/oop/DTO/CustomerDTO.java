package com.ups.oop.DTO;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class CustomerDTO {
    private Long id;
    private String customername;
    private String customerlastName;
    private String address;
    private String phoneNumber;
    private String email;

}
