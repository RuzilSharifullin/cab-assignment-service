DELETE FROM geo_location;
DELETE FROM customer;

INSERT INTO geo_location (latitude, longitude, geo_location_id)
VALUES (45.23, 88.67, 'abc1234');
INSERT INTO customer (geo_location_id)
VALUE ('abc1234');

INSERT INTO geo_location (latitude, longitude, geo_location_id)
VALUES (11.11, 11.11, 'asd1524'),
       (22.22, 22.22, 'sgw5205'),
       (33.33, 33.33, 'hai0011'),
       (44.44, 44.44, 'dla9185'),
       (55.55, 66.66, 'fwg2551'),
       (77.77, 77.77, 'hej8284'),
       (88.88, 88.88, 'beh2421'),
       (99.99, 99.99, 'poi2059');


