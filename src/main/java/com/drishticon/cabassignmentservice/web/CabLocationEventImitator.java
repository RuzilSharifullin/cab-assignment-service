package com.drishticon.cabassignmentservice.web;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Location;
import com.drishticon.cabassignmentservice.service.CabLocationPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/event/cablocations")
public class CabLocationEventImitator {

    @Autowired
    CabLocationPublisher cabLocationPublisher;

    @GetMapping
    public String publish() {
        List<Cab> cabs = List.of(
                new Cab("mno", new Location("mno2551", 11.11, 11.11), "mno@gmail.com"),
                new Cab("prs", new Location("prs8284", 22.22, 22.22), "prs@gmail.com"),
                new Cab("cc8", new Location("cc82421", 33.33, 33.33), "cc8@gmail.com"),
                new Cab("xyz", new Location("xyz2059", 44.44, 44.44), "xyz@gmail.com"),
                new Cab("bbb", new Location("bbb5214", 55.55, 55.55), "bbb@gmail.com"),
                new Cab("aaa", new Location("aaa5214", 66.66, 66.66), "aaa@gmail.com"),
                new Cab("ccc", new Location("ccc5214", 77.77, 77.77), "ccc@gmail.com"),
                new Cab("ddd", new Location("ddd5214", 88.88, 88.88), "ddd@gmail.com"),
                new Cab("eee", new Location("eee5214", 99.99, 99.99), "eee@gmail.com"),
                new Cab("fff", new Location("fff5214", 100.10, 100.10), "fff@gmail.com")
        );

        for (Cab cab : cabs) {
            cabLocationPublisher.publish(cab);
        }
        return "Done!";
    }

}
