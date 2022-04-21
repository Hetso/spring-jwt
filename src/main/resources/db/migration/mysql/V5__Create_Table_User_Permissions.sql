CREATE TABLE IF NOT EXISTS `user_permissions` (
  `user_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`permission_id`),
  KEY `fk_user_permissions_permission` (`permission_id`),
  CONSTRAINT `fk_user_permissions_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_user_permissions_permission` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`)
);