USE helloroomie;

INSERT INTO CITY (NAME) VALUES ('New Delhi'), ('Pune'), ('Bengaluru'), ('Hyderabad');

INSERT INTO ZONE (NAME, CITY_ID) VALUES ('North Delhi', 1), ('South Delhi', 1), ('East Delhi', 1), ('West Delhi', 1), ('Central Delhi', 1),
('North Pune', 2), ('South Pune', 2), ('East Pune', 2), ('West Pune', 2), ('Central Pune', 2);

INSERT INTO LOCALITY (NAME, ZONE_ID) VALUES ('Malviya Nagar', 2), ('Punjabi Bagh', 4), ('Model Town', 1), ('Chandni Chowk', 5), ('Shahdara', 3),
('Hinjewadi', 6), ('Hinjewadi', 7), ('Hinjewadi', 8), ('Hinjewadi', 9), ('Hinjewadi', 10);