
CREATE DATABASE the_dragon

DROP TABLE IF EXISTS `the_dragon`.`accounts`;
CREATE TABLE `the_dragon`.`accounts` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `role_id` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `the_dragon`.`customers`;
CREATE TABLE `the_dragon`.`customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email`    varchar(100) NOT NULL,
  `phone`    varchar(20) NOT NUll,
  `status` tinyint(1) NOT NULL,
  `role_id` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, role_id) VALUES ('truong_nguyen', '123456', 'truongnguyen1110@gmail.com', '0123456789', '1', '1');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, role_id) VALUES ('nhan_nguyen', '123456', 'vunhankhtn@gmail.com', '0123456789', '1', '2');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, role_id) VALUES ('thoai_tran', '123456', 'thoaitran@gmail.com', '0123456788', '1', '3');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, role_id) VALUES ('vu_cao', '123456', 'caohongvu@gmail.com', '1234556778', '1', '3');



DROP TABLE IF EXISTS `the_dragon`.`hotels`;
CREATE TABLE `the_dragon`.`hotels` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `number_of_rooms` int(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `hotel_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`hotels` (name, number_of_rooms, address, district, city, hotel_status) VALUES ('Hotel CIS 1', '10', '2 Hong Ha', 'Tan Binh', 'Ho Chi Minh', '1');
INSERT INTO `the_dragon`.`hotels` (name, number_of_rooms, address, district, city, hotel_status) VALUES ('Hotel CIS 2', '10', '2 Hong Ha', 'Tan Binh', 'Ho Chi Minh', '1');
INSERT INTO `the_dragon`.`hotels` (name, number_of_rooms, address, district, city, hotel_status) VALUES ('Hotel CIS 3', '10', '2 Hong Ha', 'Tan Binh', 'Ho Chi Minh', '1');



DROP TABLE IF EXISTS `the_dragon`.`rooms`;
CREATE TABLE `the_dragon`.`rooms` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `number_of_guest` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `district` int(10) NOT NULL,
  `city` int(10) NOT NULL,
  `images` varchar(1000) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM201', 500000, 3, 'Description of room', 1, 1, 1, '/static/room/1/1.png|/static/room/1/2.png|/static/room/1/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM202', 300000, 2, 'Description of room', 1, 1, 1, '/static/room/2/1.png|/static/room/2/2.png|/static/room/2/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM203', 400000, 3, 'Description of room', 1, 2, 1, '/static/room/3/1.png|/static/room/3/2.png|/static/room/3/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM204', 200000, 2, 'Description of room', 1, 3, 1, '/static/room/4/1.png|/static/room/4/2.png|/static/room/4/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM205', 100000, 1, 'Description of room', 1, 4, 2, '/static/room/5/1.png|/static/room/5/2.png|/static/room/5/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM206', 600000, 3, 'Description of room', 1, 3, 2, '/static/room/6/1.png|/static/room/6/2.png|/static/room/6/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM207', 700000, 4, 'Description of room', 1, 2, 2, '/static/room/7/1.png|/static/room/7/2.png|/static/room/7/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM208', 800000, 4, 'Description of room', 1, 2, 2, '/static/room/8/1.png|/static/room/8/2.png|/static/room/8/3.png', 1);
INSERT INTO `the_dragon`.`rooms` (code, price, number_of_guest, description, type, district, city, images, status) 
VALUES ('ROOM209', 400000, 3, 'Description of room', 1, 1, 1, '/static/room/9/1.png|/static/room/9/2.png|/static/room/9/3.png', 1);




DROP TABLE IF EXISTS `the_dragon`.`bookings`;
CREATE TABLE `the_dragon`.`bookings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) NOT NULL,
  `room_id` int(10) NOT NULL,
  `customer_id` int(10) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `number_of_guess` int(10) NOT NULL,
  `from_date` datetime NOT NULL,
  `to_date` datetime NOT NULL,
  `total_amount` decimal(10, 2) NOT NULL,
  `booking_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`bookings` (hotel_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 1, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);
INSERT INTO `the_dragon`.`bookings` (hotel_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 2, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);
INSERT INTO `the_dragon`.`bookings` (hotel_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 3, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);
