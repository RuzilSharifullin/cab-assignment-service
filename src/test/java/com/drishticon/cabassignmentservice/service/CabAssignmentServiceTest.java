package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.domain.Location;
import com.drishticon.cabassignmentservice.repository.CabRepository;
import com.drishticon.cabassignmentservice.repository.CustomerRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static com.drishticon.cabassignmentservice.TestCabData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class CabAssignmentServiceTest {

    @Test
    void getAvailableCabsNextTo() {
        Customer customer = new Customer(123, new Location("abc1234", 33.33, 33.33));
        CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
        when(customerRepository.getByLocationId("abc1234")).
                thenReturn(customer);

        List<Cab> cabs = List.of(CAB2, CAB3, CAB4);
        CabRepository cabRepository = Mockito.mock(CabRepository.class);
        when(cabRepository.getAvailableCabsNextTo(customer.getLocation(), 3)).
                thenReturn(cabs);

        CabAssignmentService cabAssignmentService = new CabAssignmentService(cabRepository, customerRepository);
        assertThat(cabAssignmentService.getAvailableCabsNextTo("abc1234", 3)).
                hasSameElementsAs(cabs);
    }
}