
CREATE DATABASE the_dragon


DROP TABLE IF EXISTS `the_dragon`.`customers`;
CREATE TABLE `the_dragon`.`customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email`    varchar(100) NOT NULL,
  `phone`    varchar(20) NOT NUll,
  `status` tinyint(1) NOT NULL,
  `avatar` varchar(500) NOT NULL,
  `role_id` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, avatar, role_id) VALUES ('truong_nguyen', '123456', 'truongnguyen1110@gmail.com', '0123456789', '1', '/static/img/customer/1.jpg', '1');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, avatar, role_id) VALUES ('nhan_nguyen', '123456', 'vunhankhtn@gmail.com', '0123456789', '1', '/static/img/customer/2.jpg', '2');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, avatar, role_id) VALUES ('thoai_tran', '123456', 'thoaitran@gmail.com', '0123456788', '1', '/static/img/customer/3.jpg', '3');
INSERT INTO `the_dragon`.`customers` (username, password, email, phone, status, avatar, role_id) VALUES ('vu_cao', '123456', 'caohongvu@gmail.com', '1234556778', '1', '/static/img/customer/4.jpg', '3');



DROP TABLE IF EXISTS `the_dragon`.`homes`;
CREATE TABLE `the_dragon`.`homes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `number_of_rooms` int(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` int(10) NOT NULL,
  `images` varchar(1000) NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`homes` (name, number_of_rooms, address, city, images, status) 
VALUES ('Vung Tau City', 5, 'Vung Tau City', 5, '/static/img/home/1/home1.jpg', 1);
INSERT INTO `the_dragon`.`homes` (name, number_of_rooms, address, city, images, status) 
VALUES ('Vinhomes Central Park - Ho Chi Minh City', 17, 'Binh Thanh district', 1, '/static/img/home/2/home2.jpg', 1);
INSERT INTO `the_dragon`.`homes` (name, number_of_rooms, address, city, images, status) 
VALUES ('Ho Chi Minh City Center', 28, 'Ho Chi Minh City', 1, '/static/img/home/3/home3.jpg', 1);
INSERT INTO `the_dragon`.`homes` (name, number_of_rooms, address, city, images, status) 
VALUES ('TDH Tre Tresor', 3, 'Ho Chi Minh City', 1, '/static/img/home/4/home4.jpg', 1);
INSERT INTO `the_dragon`.`homes` (name, number_of_rooms, address, city, images, status) 
VALUES ('Vinhomes Golden River - Ho Chi Minh City', 2, 'District 1, Ho Chi Minh City', 1, '/static/img/home/5/home5.jpg', 1);




DROP TABLE IF EXISTS `the_dragon`.`room`;
CREATE TABLE `the_dragon`.`room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `home_id` int(10) NOT NULL,
  `code` varchar(50) NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  `number_of_guest` varchar(100) NOT NULL,
  `description` varchar(500) NOT NULL,
  `type` tinyint(1) NOT NULL,
  `bedroom` int(10) NOT NULL,
  `bed` int(10) NOT NULL,
  `bath` int(10) NOT NULL,
  `district` int(10) NOT NULL,
  `province` int(10) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



INSERT INTO `the_dragon`.`room` (code, home_id, price, number_of_guest, description, type, bedroom, bed, bath, district, province, status) 
VALUES ('The Dragons Host @ Vung Tau Melody 2 BRs B0407', 1, 625676, 6, 'Description of room', 1, 2, 3, 4, 1, 3, 1);

INSERT INTO `the_dragon`.`room` (code, home_id, price, number_of_guest, description, type, bedroom, bed, bath, district, province, status) 
VALUES ('The Dragons Host @ Vung Tau Melody 3 BRs A1112', 1, 1042794, 8, 'Description of room', 1, 2, 3, 4, 1, 3, 1);

INSERT INTO `the_dragon`.`room` (code, home_id, price, number_of_guest, description, type, bedroom, bed, bath, district, province, status) 
VALUES ('The Dragons Host @ Vung Tau Melody 2 BRs B1809', 1, 1042794, 8, 'Description of room', 1, 2, 3, 4, 1, 3, 1);

INSERT INTO `the_dragon`.`room` (code, home_id, price, number_of_guest, description, type, bedroom, bed, bath, district, province, status) 
VALUES ('The Dragons Host @ Vung Tau Melody 2 BRs A0525', 1, 509810, 6, 'Description of room', 1, 2, 3, 4, 1, 3, 1);

INSERT INTO `the_dragon`.`room` (code, home_id, price, number_of_guest, description, type, bedroom, bed, bath, district, province, status) 
VALUES ('The Dragons Host @ Vung Tau Melody 2 BRs B0407', 1, 1,042,794, 8, 'Description of room', 1, 2, 3, 4, 1, 3, 1);



DROP TABLE IF EXISTS `the_dragon`.`room_detail`;
CREATE TABLE `the_dragon`.`room_detail` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_id` int(10) NOT NULL,
  `title`   varchar(200) NOT NULL,
  `amenity` varchar(100) NOT NULL,
  `bedroom` int(10) NOT NULL,
  `bed`     int(10) NOT NULL,
  `bath`    int(10) NOT NULL,
  `short_description` text NOT NULL,
  `long_description`  text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`room_detail` (room_id, title, amenity, bedroom, bed, bath, short_description, long_description) 
VALUES (1, 'The Dragons Host @ Vung Tau Melody 3BRs B1809', '1|2|3|4|5', 1, 1, 1, 'Vungtau Melody Residences is an 5 minute walk from the beach.',

'The apartment is on the floor 9 with fully furnished, complete privacy, quiet and secure which can host up to 8 people, ideal for business travelers, family (with kids and old people) or a group of friends. Why to STAY HERE?
- BEDROOMS: 3 bedrooms with 1 king bed, 2 queen beds, fresh linens and towels are provided. Iron and make up vanity. Wardrobe and clothes hangers.
- LIVING ROOM: Sofa bed/ LCD Television with 100++ International TV channels
- BATHROOM: 2 bathrooms with shower, hot water, towels, toilet papers, soap, hand soap, shampoo and shower set are all provided. 
- KITCHEN: large fridge, microwave, stove, kettle along with cooking utensils, full dinner set and glasses.
- LAUNDRY ROOM: washing machine, washing power and outdoor clothes hangers

OTHERS:
• Balcony with city view/ mountain vie (Website hidden by Airbnb) Hot water
• High speed wireless internet
• Internet TV Cable with 100+ international and local channels
• Air conditioning
• Taxi service at the door
• 24/7 building & home access
• Smart key 
• Family/ Kid friendly

Everything is designed to unwind you from the moment you walk in. Come and enjoy your stay, feel Like Your Home! 24/7 building & home access. 
We give our guests space but are available when needed. We love to make our guest feel welcome and at home. Other our apartment in Vung Tau Melody (see in our profile)
- 3 Bedroom Apartments: Unit A (Phone number hidden by Airbnb) - 2 Bedroom Apartments: Unit A (Phone number hidden by Airbnb)');



DROP TABLE IF EXISTS `the_dragon`.`bookings`;
CREATE TABLE `the_dragon`.`bookings` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `home_id` int(10) NOT NULL,
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
INSERT INTO `the_dragon`.`bookings` (home_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 1, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);
INSERT INTO `the_dragon`.`bookings` (home_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 2, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);
INSERT INTO `the_dragon`.`bookings` (home_id, room_id, customer_id, price, number_of_guess, from_date, to_date, total_amount, booking_status) VALUES (1, 1, 3, 100000, 10, '2019-01-01 08:40:00', '2019-01-06 08:40:00', 500000, 1);



DROP TABLE IF EXISTS `the_dragon`.`amenity`;
CREATE TABLE `the_dragon`.`amenity` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(10) NOT NULL,
  `name`   varchar(200) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`amenity` (category_id, name, description) VALUES (1, 'Air conditioning', '');
INSERT INTO `the_dragon`.`amenity` (category_id, name, description) VALUES (1, 'Cable TV', '');
INSERT INTO `the_dragon`.`amenity` (category_id, name, description) VALUES (1, 'Ethernet connection', '');
INSERT INTO `the_dragon`.`amenity` (category_id, name, description) VALUES (1, 'Essentials', 'Towels, bed sheets, soap, and toilet paper');
INSERT INTO `the_dragon`.`amenity` (category_id, name, description) VALUES (1, 'Laptop friendly workspace', 'A table or desk with space for a laptop and a chair that’s comfortable to work in');

DROP TABLE IF EXISTS `the_dragon`.`amenity_category`;
CREATE TABLE `the_dragon`.`amenity_category` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name`   varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Basic');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Family features');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Facilities');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Dining');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Guest access');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Logistics');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Bed and bath');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Outdoor');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Location');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Safety features');
INSERT INTO `the_dragon`.`amenity_category` (name) VALUES ('Not included');




DROP TABLE IF EXISTS `the_dragon`.`accessibility`;
CREATE TABLE `the_dragon`.`accessibility` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` int(10) NOT NULL,
  `name`   varchar(200) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (1, 'Step-free access', '');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (1, 'Well-lit path to entrance', '');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (2, 'Wide hallway clearance', 'The hallways on the ground floor are at least 36 inches wide.');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (3, 'Step-free access', '');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (3, 'Step-free access', '');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (4, 'Wide entryway', '');
INSERT INTO `the_dragon`.`accessibility` (category_id, name, description) VALUES (5, 'Disabled parking spot', 'There’s a parking spot at least 8 feet wide.');

DROP TABLE IF EXISTS `the_dragon`.`accessibility_category`;
CREATE TABLE `the_dragon`.`accessibility_category` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name`   varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Entering the home');
INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Getting around');
INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Bedroom');
INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Bathroom');
INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Common areas');
INSERT INTO `the_dragon`.`accessibility_category` (name) VALUES ('Parking');



DROP TABLE IF EXISTS `the_dragon`.`provinces`;
CREATE TABLE `the_dragon`.`provinces` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name`    varchar(300) NOT NULL,
  `type`    varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `the_dragon`.`provinces` (name, type) VALUES ('Ho Chi Minh', 'City');
INSERT INTO `the_dragon`.`provinces` (name, type) VALUES ('Ha Noi', 'City');
INSERT INTO `the_dragon`.`provinces` (name, type) VALUES ('Vung Tau', 'City');

DROP TABLE IF EXISTS `the_dragon`.`districts`;
CREATE TABLE `the_dragon`.`districts` (
  `id`      int(10) unsigned NOT NULL AUTO_INCREMENT,
  `province_id` int(10) NOT NULL,
  `name`    varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `the_dragon`.`districts` (province_id, name, type) VALUES (1, 'Can Gio',);
INSERT INTO `the_dragon`.`districts` (province_id, name, type) VALUES (1, 'Binh Thanh');
INSERT INTO `the_dragon`.`districts` (province_id, name, type) VALUES (1, 'Binh Chanh');



DROP TABLE IF EXISTS `the_dragon`.`reviews`;
CREATE TABLE `the_dragon`.`reviews` (
  `id`             int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_detail_id` int(10) NOT NULL,
  `customer_id`    int(10) NOT NULL,
  `content`        text NOT NULL,
  `created_at`     datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (1, 1, "Exceptional value, a newly furnished modern apartment located in the heart of the city. The best experience I've ever had with Airbnb, will highly recommend The Dragons Hosts' properties without a doubt", '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (1, 2, 'Clean & nice apartment. I would bring my family here again whenever I am in VT.', '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (1, 3, '바다 도보로 5-7분정도 떨어져있고 주변에 편의점도 있고 새로지은 신축아파트라서 엄청 깨끗해요. 추천합니다.', '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (1, 4, 'The apartment is very clean . The host is very friendly and helpful', '2019-01-09 18:23:34');

INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (2, 1, "Exceptional value, a newly furnished modern apartment located in the heart of the city. The best experience I've ever had with Airbnb, will highly recommend The Dragons Hosts' properties without a doubt", '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (2, 2, 'Clean & nice apartment. I would bring my family here again whenever I am in VT.', '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (2, 3, '바다 도보로 5-7분정도 떨어져있고 주변에 편의점도 있고 새로지은 신축아파트라서 엄청 깨끗해요. 추천합니다.', '2019-01-09 18:23:34');
INSERT INTO `the_dragon`.`reviews` (room_detail_id, customer_id, content, created_at) VALUES (2, 4, 'The apartment is very clean . The host is very friendly and helpful', '2019-01-09 18:23:34');



DROP TABLE IF EXISTS `the_dragon`.`room_image`;
CREATE TABLE `the_dragon`.`room_image` (
  `id`             int(10) unsigned NOT NULL AUTO_INCREMENT,
  `room_id` int(10) NOT NULL,
  `image`    int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/1.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/2.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/3.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/4.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/5.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/6.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/7.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/8.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/9.png');
INSERT INTO `the_dragon`.`room_image` (room_id, image) VALUES (1, '/static/room/1/10.png');
