package com.drishticon.cabassignmentservice.repository;

import com.drishticon.cabassignmentservice.domain.Customer;

public interface CustomerRepository {

    Customer getByCustomerId(int id);

    Customer getByLocationId(String id);

    Customer save(Customer customer);
}
