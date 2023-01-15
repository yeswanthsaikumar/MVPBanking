package com.bank.customer.service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.customer.service.entities.Customer;
import com.bank.customer.service.exception.ResourceNotFoundException;
import com.bank.customer.service.repository.CustomerRepository;
import com.bank.customer.service.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
	return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
	return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
	return customerRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
	return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(Long id) {
	Customer customer = customerRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Customer with the following ID was not found: " + id));
	if (customer != null) {
	    customerRepository.delete(customer);
	}
	return customer;
    }

}
