package com.drishticon.cabassignmentservice.repository;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Location;

import java.util.List;

public interface CabRepository {

    List<Cab> getAvailableCabsNextTo(Location location, int requestedNumberOfCabs);

    Cab save(Cab cab);
}
