package com.ups.oop.repository;

import com.ups.oop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long > {
}
