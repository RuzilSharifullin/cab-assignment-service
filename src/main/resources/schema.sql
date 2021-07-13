DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS cab;

CREATE TABLE location
(
    location_id     VARCHAR(7) PRIMARY KEY,
    latitude        FLOAT NOT NULL DEFAULT 0.0,
    longitude       FLOAT NOT NULL DEFAULT 0.0
);

CREATE TABLE customer
(
    customer_id     INT PRIMARY KEY AUTO_INCREMENT,
    location_id     VARCHAR(7) REFERENCES location(location_id)
)   ENGINE=InnoDB AUTO_INCREMENT=123;

CREATE TABLE cab
(
    cab_id          VARCHAR(3)  PRIMARY KEY,
    driver_email    VARCHAR(20) UNIQUE,
    is_assigned     BOOLEAN DEFAULT FALSE,
    location_id     VARCHAR(20) REFERENCES location(location_id)
);