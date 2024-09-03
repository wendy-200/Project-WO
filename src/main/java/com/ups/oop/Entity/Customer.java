package com.ups.oop.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String id;
    private String Customername;
    private String CustomerlastName;
    private String address;
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name = "customer")
    private List<Invoice> invoice;


}
