package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer get(int id) {
        Customer customer = repository.getByCustomerId(id);
        return repository.getByCustomerId(id);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }
}
