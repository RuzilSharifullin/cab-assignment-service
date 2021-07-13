package com.drishticon.cabassignmentservice.repository.jpa;

import com.drishticon.cabassignmentservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepositoryJpaImpl extends JpaRepository<Customer, Integer> {
    Customer findByLocationId(String id);
}
