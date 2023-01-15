package com.bank.customer.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.customer.service.entities.Customer;
import com.bank.customer.service.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	Customer customerObj = customerService.saveCustomer(customer);
	return ResponseEntity.status(HttpStatus.CREATED).body(customerObj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getSingleUser(@PathVariable Long id) {
	Customer customer = customerService.getCustomer(id);
	return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
	List<Customer> customers = customerService.getAllCustomers();
	return ResponseEntity.ok(customers);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
	Customer customerObj = customerService.updateCustomer(customer);
	return ResponseEntity.ok(customerObj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
	Customer customer = customerService.deleteCustomer(id);
	return ResponseEntity.ok(customer);
    }

}
