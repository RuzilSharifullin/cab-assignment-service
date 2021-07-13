DROP TABLE IF EXISTS geo_location;
DROP TABLE IF EXISTS customer;

CREATE TABLE geo_location
(
    geo_location_id VARCHAR(7) PRIMARY KEY,
    latitude        FLOAT NOT NULL DEFAULT 0.0,
    longitude       FLOAT NOT NULL DEFAULT 0.0
);

CREATE TABLE customer
(
    customer_id     INT PRIMARY KEY AUTO_INCREMENT,
    geo_location_id VARCHAR(7) REFERENCES geo_location(geo_location_id)
)   ENGINE=InnoDB AUTO_INCREMENT=123;
