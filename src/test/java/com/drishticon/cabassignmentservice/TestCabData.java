package com.drishticon.cabassignmentservice;

import com.drishticon.cabassignmentservice.domain.Cab;
import com.drishticon.cabassignmentservice.domain.Location;

import java.util.List;

public class TestCabData {
    public static final Cab CAB1 = new Cab("mno", new Location("mno2551", 11.11, 11.11), "mno@gmail.com");
    public static final Cab CAB2 = new Cab("prs", new Location("prs8284", 22.22, 22.22), "prs@gmail.com");
    public static final Cab CAB3 = new Cab("yyy", new Location("yyy2421", 33.33, 33.33), "yyy@gmail.com");
    public static final Cab CAB4 = new Cab("xyz", new Location("xyz2059", 44.44, 44.44), "xyz@gmail.com");
    public static final Cab CAB5 = new Cab("bbb", new Location("bbb5214", 55.55, 55.55), "bbb@gmail.com");
    public static final Cab CAB6 = new Cab("aaa", new Location("aaa5214", 66.66, 66.66), "aaa@gmail.com");
    public static final Cab CAB7 = new Cab("ccc", new Location("ccc5214", 77.77, 77.77), "ccc@gmail.com");
    public static final Cab CAB8 = new Cab("ddd", new Location("ddd5214", 88.88, 88.88), "ddd@gmail.com");
    public static final Cab CAB9 = new Cab("eee", new Location("eee5214", 99.99, 99.99), "eee@gmail.com");
    public static final Cab CAB10 = new Cab("fff", new Location("fff5214", 100.10, 100.10), "fff@gmail.com");

    public static final List<Cab> CABS = List.of(CAB1, CAB2, CAB3, CAB4, CAB5, CAB6, CAB7, CAB8, CAB9, CAB10);
}
