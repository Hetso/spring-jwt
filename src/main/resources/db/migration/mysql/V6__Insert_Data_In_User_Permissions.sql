INSERT INTO `user_permissions` (`user_id`, `permission_id`) VALUES
	((SELECT id FROM `users` WHERE username = 'admin'), (SELECT id FROM `permissions` WHERE `name` = 'ADMIN')),
	((SELECT id FROM `users` WHERE username = 'user1'), (SELECT id FROM `permissions` WHERE `name` = 'COMMON_USER')),
	((SELECT id FROM `users` WHERE username = 'user2'), (SELECT id FROM `permissions` WHERE `name` = 'MANAGER'));