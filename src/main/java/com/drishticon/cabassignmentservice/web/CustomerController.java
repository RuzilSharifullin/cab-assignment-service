package com.drishticon.cabassignmentservice.web;

import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.service.CustomerService;
import com.drishticon.cabassignmentservice.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users/locations")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public Customer get() {
        //Mock authentication
        int userId = SecurityUtil.USER_ID;
        return customerService.get(userId);
    }

    @PostMapping
    public Customer update(@RequestBody Customer customer) {
        //Mock authentication
        int userId = SecurityUtil.USER_ID;
        if (customer.getId() != userId) {
            throw new IllegalArgumentException("Inconsistent data");
        }
        return customerService.save(customer);
    }
}
