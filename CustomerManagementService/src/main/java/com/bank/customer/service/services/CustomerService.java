package com.bank.customer.service.services;

import java.util.List;

import com.bank.customer.service.entities.Customer;

public interface CustomerService {

    // Add customer
    Customer saveCustomer(Customer customer);

    // Fetch all customer
    List<Customer> getAllCustomers();

    // Fetch single customer details
    Customer getCustomer(Long id);

    // Upadte customer details
    Customer updateCustomer(Customer customer);

    // Delete customer details
    Customer deleteCustomer(Long id);
}
