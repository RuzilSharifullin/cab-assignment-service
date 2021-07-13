package com.drishticon.cabassignmentservice.repository.jpa;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Location;
import com.drishticon.cabassignmentservice.repository.CabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CabRepositoryProxy implements CabRepository {

    @Autowired
    CabRepositoryJpaImpl repository;

    @Override
    public List<Cab> getAvailableCabsNextTo(Location location, int requestedNumberOfCabs) {
        return repository.getAvailableCabsNextTo(location.getLatitude(), location.getLongitude(), requestedNumberOfCabs);
    }

    @Override
    public Cab save(Cab cab) {
        return repository.save(cab);
    }
}
