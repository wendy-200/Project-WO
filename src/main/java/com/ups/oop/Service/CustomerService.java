package com.ups.oop.Service;


import com.ups.oop.dto.CustomerDTO;
import com.ups.oop.entity.Customer;
import com.ups.oop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService( CustomerRepository customerRepository){
        this.customerRepository = customerRepository;

    }
    public List<CustomerDTO> getCustomer(){
        Iterable<Customer>customerIterable = customerRepository.findAll();
        List<CustomerDTO>customerList = new ArrayList<>();


        for(Customer customer: customerIterable){
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setCustomerCode(customer.getCustomerCode());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setPhoneNumber(customer.getPhoneNumber());
            customerDTO.setEmail(customer.getEmail());
            customerList.add(customerDTO);
        }
        return customerList;
    }
}