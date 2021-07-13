package com.drishticon.cabassignmentservice.web;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.service.CabAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cabs")
public class CabAssignmentController {

    @Autowired
    private CabAssignmentService cabAssignmentService;


    @GetMapping
    public List<Cab> getAvailableCabsNextTo(@RequestParam("locations") String locationId,
                                            @RequestParam("cabs") int requestedNumberOfCabs) {
        return cabAssignmentService.getAvailableCabsNextTo(locationId, requestedNumberOfCabs);
    }

}
