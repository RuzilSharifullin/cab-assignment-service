package com.drishticon.cabassignmentservice.web;

import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.service.CustomerService;
import com.drishticon.cabassignmentservice.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

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
            throw new IllegalArgumentException("No such customer id");
        }
        return customerService.save(customer);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleException(IllegalArgumentException exception) {
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", new Timestamp(System.currentTimeMillis()).toString());
        map.put("error", exception.toString());
        return new ResponseEntity(map, HttpStatus.UNAUTHORIZED);
    }
}
