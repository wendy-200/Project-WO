package com.ups.oop.Service;

import com.ups.oop.DTO.CustomerDTO;
import com.ups.oop.Entity.Customer;
import com.ups.oop.Repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private List<CustomerDTO> customerDTOList = new ArrayList<>();

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository =customerRepository;

    }

    public ResponseEntity createCustomer(CustomerDTO customerDTO) {
        boolean wasFound = findCustomer(String.valueOf(customerDTO.getId()));
        if (wasFound) {
            String errorMessage = "invoice with id" + customerDTO.getId() + "already exists";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            customerDTOList.add(customerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        }
    }

    private boolean findCustomer(String id) {
        for (CustomerDTO customerDTO : customerDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(customerDTO.getId()))) {
                return true;
            }
        }
        return false;
    }

    public ResponseEntity getAllCustomer() {
        Iterable<Customer> customerIterable = customerRepository.findAll();
        List<CustomerDTO> customers = new ArrayList<>();
        for (Customer Cu : customerIterable) {
            CustomerDTO customer = new CustomerDTO();
            customer.setId(customer.getId());
            customer.setCustomername(customer.getCustomername());
            customer.setCustomerlastName(customer.getCustomerlastName());
            customer.setAddress(customer.getAddress());
            customer.setPhoneNumber(customer.getPhoneNumber());
            customer.setEmail(customer.getEmail());
            customers.add(customer);

        }
        if (customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    public ResponseEntity getCustomerById(String id) {
        Optional<Customer> customerOptional = customerRepository.findById(Long.valueOf(id));
        if(customerOptional.isPresent()){
            Customer customerFound = customerOptional.get();
            CustomerDTO customer = new CustomerDTO();
            customer.setId(Long.valueOf(customerFound.getId()));
            customer.setCustomername(customerFound.getCustomername());
            customer.setCustomerlastName(customerFound.getCustomerlastName());
            customer.setAddress(customerFound.getAddress());
            customer.setPhoneNumber(customerFound.getPhoneNumber());
            customer.setEmail(customerFound.getEmail());

            return  ResponseEntity.status(HttpStatus.OK).body(customer);

        }else{

            String errorMessage = "customer with id" + id + " already exists";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }

    private int findIndexById(String id) {
        int index = 0;
        for (CustomerDTO Cu : customerDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(Cu.getId()))) {
                return index;
            }
            index++;
        }
        return -1;

    }

    public ResponseEntity updateCustomer(CustomerDTO customerDTO) {
        int upadateIndex = findIndexById(String.valueOf(customerDTO.getId()));
        if (upadateIndex != -1) {
            customerDTOList.set(upadateIndex, customerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("customer with id " + customerDTO.getId() + " doesn't exits ");

    }

    public ResponseEntity deleteCustomerById(String id) {
        String message = "customer with id " + id;
        for (CustomerDTO inv : customerDTOList) {
            if (id.equalsIgnoreCase(String.valueOf(inv.getId()))) {
                customerDTOList.remove(inv);
                return ResponseEntity.status(HttpStatus.OK).body(message + " removed successfully");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
    }
}
