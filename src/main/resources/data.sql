CREATE TABLE hotel
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR(255),
    address_street  VARCHAR(255),
    address_city    VARCHAR(255),
    address_state   VARCHAR(255),
    address_country VARCHAR(255),
    address_zipcode VARCHAR(10),
    stars_count     INT
);

CREATE TABLE room
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    hotel_id        BIGINT,
    bed_count       TINYINT,
    is_pet_friendly BOOLEAN,
    price           DECIMAL(10, 2),
    FOREIGN KEY (hotel_id) REFERENCES hotel (id)
);

CREATE TABLE user_
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email    VARCHAR(255) NOT NULL
);

CREATE TABLE booking
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id      BIGINT,
    room_id      BIGINT,
    booking_date TIMESTAMP NOT NULL,
    start_date   DATE      NOT NULL,
    end_date     DATE      NOT NULL,
    price        DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES user_ (id),
    FOREIGN KEY (room_id) REFERENCES room (id)
);

INSERT INTO user_ (username, email)
VALUES ('user1', 'user1@example.com'),
       ('user2', 'user2@example.com'),
       ('user3', 'user3@example.com'),
       ('user4', 'user4@example.com'),
       ('user5', 'user5@example.com'),
       ('user6', 'user6@example.com'),
       ('user7', 'user7@example.com'),
       ('user8', 'user8@example.com'),
       ('user9', 'user9@example.com'),
       ('user10', 'user10@example.com');

INSERT INTO hotel (title, address_street, address_city, address_state, address_country, address_zipcode, stars_count)
VALUES ('Hotel A', '123 Main St', 'City A', 'State A', 'Country A', '12345', 5),
       ('Hotel B', '456 Elm St', 'City B', 'State B', 'Country B', '67890', 4),
       ('Hotel C', '789 Oak St', 'City C', 'State C', 'Country C', '13579', 3),
       ('Hotel D', '321 Maple St', 'City D', 'State D', 'Country D', '24680', 4),
       ('Hotel E', '543 Pine St', 'City E', 'State E', 'Country E', '97531', 5),
       ('Hotel F', '987 Birch St', 'City F', 'State F', 'Country F', '86420', 3),
       ('Hotel G', '654 Cedar St', 'City G', 'State G', 'Country G', '75319', 4),
       ('Hotel H', '234 Walnut St', 'City H', 'State H', 'Country H', '46802', 5),
       ('Hotel I', '876 Chestnut St', 'City I', 'State I', 'Country I', '12368', 4),
       ('Hotel J', '432 Sycamore St', 'City J', 'State J', 'Country J', '97531', 3);


INSERT INTO room (hotel_id, bed_count, is_pet_friendly, price)
VALUES (1, 2, true, 100.00),
       (1, 2, true, 120.00),
       (1, 1, false, 80.00),
       (2, 3, false, 150.00),
       (2, 2, true, 110.00),
       (3, 1, true, 90.00),
       (4, 2, false, 120.00),
       (5, 2, true, 130.00),
       (5, 3, false, 160.00),
       (6, 1, true, 85.00);

INSERT INTO booking (user_id, room_id, booking_date, start_date, end_date, price)
VALUES (1, 1, '2024-04-23 10:00:00', '2024-05-01', '2024-05-05', 500.00),
       (2, 2, '2024-04-24 11:00:00', '2024-05-02', '2024-05-06', 600.00),
       (3, 3, '2024-04-25 12:00:00', '2024-05-03', '2024-05-07', 480.00),
       (4, 4, '2024-04-26 13:00:00', '2024-05-04', '2024-05-08', 720.00),
       (5, 5, '2024-04-27 14:00:00', '2024-05-05', '2024-05-09', 550.00),
       (6, 6, '2024-04-28 15:00:00', '2024-05-06', '2024-05-10', 640.00),
       (7, 7, '2024-04-29 16:00:00', '2024-05-07', '2024-05-11', 700.00),
       (8, 8, '2024-04-30 17:00:00', '2024-05-08', '2024-05-12', 800.00),
       (9, 9, '2024-05-01 18:00:00', '2024-05-09', '2024-05-13', 670.00),
       (10, 10, '2024-05-02 19:00:00', '2024-05-10', '2024-05-14', 730.00);

