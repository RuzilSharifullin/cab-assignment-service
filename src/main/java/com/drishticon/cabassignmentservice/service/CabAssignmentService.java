package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.repository.CabRepository;
import com.drishticon.cabassignmentservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CabAssignmentService {

    CabRepository cabRepository;

    CustomerRepository customerRepository;

    public CabAssignmentService(CabRepository cabRepository, CustomerRepository customerRepository) {
        this.cabRepository = cabRepository;
        this.customerRepository = customerRepository;
    }

    public List<Cab> getAvailableCabsNextTo(String locationId, int requestedNumberOfCabs) {
        Customer customer = customerRepository.getByLocationId(locationId);
        return cabRepository.getAvailableCabsNextTo(customer.getLocation(), requestedNumberOfCabs);
    }

}
