package com.bank.customer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.customer.service.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
