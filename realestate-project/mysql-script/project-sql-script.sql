


CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `enabled` tinyint NOT NULL DEFAULT 1,
  `first_name` varchar(64) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `role` (name)
VALUES 
('ROLE_EMPLOYEE');

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `business` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(45) DEFAULT NULL,
`address` varchar(150) DEFAULT NULL,
`phone_number` varchar(15) DEFAULT NULL,
`email` varchar(45) DEFAULT NULL,
`user_id` int DEFAULT NULL,
`uid` int DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `FK_USER_idx` (`user_id`),
CONSTRAINT `FK_USER_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


CREATE TABLE `property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `number_of_rooms` int DEFAULT NULL,
  `floor` int DEFAULT NULL,
  `total_floors` int DEFAULT NULL,
  `heating` varchar(45) DEFAULT NULL,
  `business_id` int DEFAULT NULL,
  `size` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_BUSINESS_idx` (`business_id`),
  CONSTRAINT `FK_BUSINESS_1` FOREIGN KEY (`business_id`) REFERENCES `business` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;




