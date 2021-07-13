package com.drishticon.cabassignmentservice.repository.jpa;

import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryProxy implements CustomerRepository {

    @Autowired
    private CustomerRepositoryJpaImpl repository;

    @Override
    public Customer getByCustomerId(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }
}
