CREATE TABLE `freelancers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT current_timestamp(6),
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `view_count` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

insert into `freelancers` (`created_at`, `id`, `name`, `updated_at`, `view_count`) values ('2024-09-30 12:50:45.356684', 1, 'test', NULL, 2);
insert into `freelancers` (`created_at`, `id`, `name`, `updated_at`, `view_count`) values ('2024-09-30 12:51:10.581188', 2, 'test2', NULL, 0);
insert into `freelancers` (`created_at`, `id`, `name`, `updated_at`, `view_count`) values ('2024-09-30 12:51:25.077156', 3, 'test3', NULL, 0);

CREATE TABLE `freelancer_view_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT current_timestamp(6),
  `freelancer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

CREATE TABLE `points` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `freelancer_id` int(11) NOT NULL,
    `charge_point` int(11) NOT NULL,
    `result_point` int(11) NOT NULL,
    `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`),
    KEY `points_index_2` (`freelancer_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_uca1400_ai_ci;

CREATE TABLE `payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pg_type` varchar(255) NOT NULL,
  `order_id` varchar(255) NOT NULL,
  `payment_key` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `total_amount` int(11) NOT NULL,
  `balance_amount` int(11) NOT NULL,
  `supplied_amount` int(11) NOT NULL,
  `vat` int(11) NOT NULL,
  `requested_at` datetime NOT NULL,
  `approve_at` datetime NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `freelancer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:23:26', 1, 2, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:25:16', 1, 3, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:26:14', 1, 4, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:30:13', 1, 5, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:32:06', 1, 6, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:38:18', 1, 7, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:46:15', 1, 12, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:47:32', 1, 13, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:48:12', 1, 14, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:49:08', 1, 15, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:53:59', 1, 16, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 03:54:21', 1, 17, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:01:09', 1, 19, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:01:39', 1, 20, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:45:06', 1, 21, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:55:53', 1, 22, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:56:34', 1, 23, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:57:15', 1, 24, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 04:59:24', 1, 25, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 05:02:03', 1, 26, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-04 07:14:36', 1, 27, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-05 05:47:34', 1, 28, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-05 09:29:56', 1, 29, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 02:59:27', 1, 30, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 07:26:23', 1, 31, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 07:27:17', 1, 32, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 07:28:47', 1, 33, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 08:46:37', 1, 34, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);
insert into `payments` (`approve_at`, `balance_amount`, `created_at`, `freelancer_id`, `id`, `order_id`, `payment_key`, `pg_type`, `requested_at`, `status`, `supplied_amount`, `total_amount`, `vat`) values ('2022-06-08 15:40:09', 15000, '2024-10-06 10:01:57', 1, 35, 'chdimFOf9tnXV5u8Xqtlo', 'B1d9edx08u7ic9yQqcTzj', '0', '2022-06-08 15:40:09', 'DONE', 13636, 15000, 1364);



CREATE TABLE `temporary_payments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) NOT NULL,
  `payment_key` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 1, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 2, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 3, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 4, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 5, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 6, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 7, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 8, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 9, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 10, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 11, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 12, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 13, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 14, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 15, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 16, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 17, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 18, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 19, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 20, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 21, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 22, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 23, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 24, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 25, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 26, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 27, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 28, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 29, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 30, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 31, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 32, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 33, '!@#', 'asdad');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 34, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 35, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 36, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 37, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 38, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 39, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 40, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 41, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 42, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 43, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 44, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 45, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 46, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 47, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 48, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 49, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 50, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 51, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 52, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 53, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 54, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 55, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (10, NULL, NULL, 56, 'sdfsdfs', '!23123');
insert into `temporary_payments` (`amount`, `created_at`, `deleted_at`, `id`, `order_id`, `payment_key`) values (100, NULL, NULL, 57, '!@#', 'asdad');
