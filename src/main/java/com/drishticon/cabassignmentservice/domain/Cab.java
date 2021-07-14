package com.drishticon.cabassignmentservice.domain;

import com.drishticon.cabassignmentservice.web.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "cab")
public class Cab {
    @Id
    @Column(name = "cab_id")
    @JsonProperty("cabId")
    @JsonView(View.PartialView.class)
    private String id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    @JsonProperty(value = "geoLocation")
    private Location location;
    @JsonProperty(value = "driverId")
    @Column(name = "driver_email")
    private String email;
    @Column(name = "is_assigned")
    private boolean isAssigned;

    public Cab() {
    }

    public Cab(String id, Location location) {
        this.id = id;
        this.location = location;
    }

    public Cab(String id, Location location, String email) {
        this.id = id;
        this.location = location;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cab cab = (Cab) o;

        if (!id.equals(cab.id)) return false;
        return location.equals(cab.location);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
