package com.drishticon.cabassignmentservice.service;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.domain.Location;
import com.drishticon.cabassignmentservice.repository.CustomerRepository;
import com.drishticon.cabassignmentservice.util.SecurityUtil;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.HamcrestCondition;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.security.auth.callback.LanguageCallback;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback
class CabAssignmentServiceTest {

    @Autowired
    CabAssignmentService cabAssignmentService;

    @Autowired
    CustomerService customerService;


    @Test
    void getAvailableCabsNextTo() {
        Customer customer = new Customer(SecurityUtil.USER_ID, new Location("abc1234", 55.00, 55.00));
        customerService.save(customer);
        List<Cab> expected = List.of(new Cab("jkl", new Location("dla9185", 44.44, 44.44)),
                new Cab("mno", new Location("fwg2551", 55.55, 55.55)),
                new Cab("prs", new Location("hej8284", 66.66, 66.66))
        );
        List<Cab> actual = cabAssignmentService.getAvailableCabsNextTo(customer.getLocation().getId(), 3);
        Assertions.assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}