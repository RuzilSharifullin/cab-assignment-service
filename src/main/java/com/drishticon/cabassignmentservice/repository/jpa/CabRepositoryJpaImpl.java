package com.drishticon.cabassignmentservice.repository.jpa;

import com.drishticon.cabassignmentservice.domain.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CabRepositoryJpaImpl extends JpaRepository<Cab, String> {

    //https://stackoverflow.com/questions/2234204/find-nearest-latitude-longitude-with-an-sql-query
    @Query(value =
            "SELECT cab_id, cab.location_id, SQRT(" +
            "POW(69.1 * (latitude - :latitude), 2) + " +
            "POW(69.1 * (:longitude - longitude) * COS(latitude / 57.3), 2)) AS distance " +
            "FROM cab JOIN location on cab.location_id = location.location_id " +
            "WHERE is_assigned = FALSE " +
            "ORDER BY distance " +
            "LIMIT :requestedNumberOfCars ;", nativeQuery = true)
    List<Cab> getAvailableCabsNextTo(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("requestedNumberOfCars") int requestedNumberOfCars);
}
