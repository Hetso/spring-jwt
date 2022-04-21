CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `enabled` TINYINT(1) DEFAULT 1,
  `account_non_locked` TINYINT(1) DEFAULT 1,
  `account_non_expired` TINYINT(1) DEFAULT 1,
  `credentials_non_expired` TINYINT(1) DEFAULT 1,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_username` (`username`),
  UNIQUE KEY `users_email` (`email`)
);