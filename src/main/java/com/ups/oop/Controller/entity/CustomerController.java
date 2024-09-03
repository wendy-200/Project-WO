package com.ups.oop.Controller.entity;


import com.ups.oop.Service.CustomerService;
import com.ups.oop.DTO.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-all-customers")
    public ResponseEntity getCustomer() {
        return this.customerService.getAllCustomer();
    }

    @GetMapping("/get-customer")
    public ResponseEntity getCustomerById(@RequestParam String id) {
        return this.customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public ResponseEntity createCustomer(@RequestBody CustomerDTO customerDTO) {
        return this.customerService.createCustomer(customerDTO);
    }


    @PutMapping("/update-customer")
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO customerDTO){
    return this.customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/remove-customer")
    public ResponseEntity deleteCustomer(@RequestParam String id){
    return this.customerService.deleteCustomerById(id);
    }
}