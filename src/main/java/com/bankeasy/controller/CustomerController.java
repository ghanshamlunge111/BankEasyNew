package com.bankeasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankeasy.entities.Customer;
import com.bankeasy.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    	Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.ok(savedCustomer); // Ensure the saved entity is returned
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
    	List<Customer> customers = customerService.getAllCustomers();
        // Log the customer list to debug
        System.out.println("Customers retrieved: " + customers);
        return ResponseEntity.ok(customers);
    }
}
