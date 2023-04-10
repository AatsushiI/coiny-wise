CREATE TABLE `users` (
    `id` varchar(26) PRIMARY KEY,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `nickname` varchar(50),
    `created_at` date,
    `updated_at` date,
    `deleted_at` date,
);