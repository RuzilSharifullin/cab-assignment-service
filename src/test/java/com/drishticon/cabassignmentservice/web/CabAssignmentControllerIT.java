package com.drishticon.cabassignmentservice.web;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Customer;
import com.drishticon.cabassignmentservice.domain.Location;
import com.drishticon.cabassignmentservice.service.CabAssignmentService;
import com.drishticon.cabassignmentservice.service.CabLocationPublisher;
import com.drishticon.cabassignmentservice.service.CustomerService;
import com.drishticon.cabassignmentservice.util.SecurityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.drishticon.cabassignmentservice.TestCabData.CABS;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CabAssignmentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CabLocationPublisher cabLocationPublisher;

    @Autowired
    private CabAssignmentService cabAssignmentService;

    @Autowired
    private CustomerService customerService;

    @Test
    void getAvailableCabsNextTo() throws Exception {
        //Initially all cabs are busy, no output
        mockMvc.perform(get("/api/v1/cabs?locations=abc1234&cabs=3")).
                andExpect(content().string("[]"));
        //Update customer location
        Customer customer = customerService.get(SecurityUtil.USER_ID);
        customer.setLocation(new Location("abc1234", 77.77, 77.77));
        customerService.save(customer);
        //Asynchronous cab_location event publishing
        for (Cab cab : CABS) {
            cabLocationPublisher.publish(cab);
        }
        Thread.sleep(2000);
        //Final assertion
        mockMvc.perform(get("/api/v1/cabs?locations=abc1234&cabs=3")).
                andExpect(jsonPath("$[*].cabId").value(containsInAnyOrder("ccc", "ddd", "aaa")));
    }
}