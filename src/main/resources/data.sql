DELETE FROM customer;
DELETE FROM cab;
DELETE FROM location;

INSERT INTO location (latitude, longitude, location_id)
VALUES (44.55, 44.55, 'abc1234');
INSERT INTO customer (location_id)
VALUE ('abc1234');

INSERT INTO location (latitude, longitude, location_id)
VALUES (11.11, 11.11, 'asd1524'),
       (22.22, 22.22, 'sgw5205'),
       (33.33, 33.33, 'hai0011'),
       (44.44, 44.44, 'dla9185'),
       (55.55, 55.55, 'fwg2551'),
       (66.66, 66.66, 'hej8284'),
       (77.77, 77.77, 'beh2421'),
       (88.88, 88.88, 'poi2059'),
       (99.99, 99.99, 'hhw5214');

INSERT INTO cab (cab_id, driver_email, location_id)
VALUES ('abc', 'mike@gmail.com', 'asd1524'),
       ('def', 'ruzil@gmail.com', 'sgw5205'),
       ('ghi', 'ryan@gmail.com', 'hai0011'),
       ('jkl', 'bob@gmail.com', 'dla9185'),
       ('mno', 'ivan@gmail.com', 'fwg2551'),
       ('prs', 'sam@gmail.com', 'hej8284'),
       ('cc8', 'test@gmail.com', 'beh2421'),
       ('xyz', 'kate@gmail.com', 'poi2059'),
       ('bbb', 'bbb@gmail.com', 'hhw5214');


