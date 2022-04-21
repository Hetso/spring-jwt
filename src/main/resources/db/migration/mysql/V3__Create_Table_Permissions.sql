CREATE TABLE IF NOT EXISTS `permissions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `permissions_name` (`name`)
);