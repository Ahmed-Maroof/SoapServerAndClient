create schema`payment-system` ;


INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO `users` (`id`, `balance`, `email`, `name`, `password`, `username`, `role_id`) VALUES ('1', '1500', 'ahmed@gmail.com', 'ahmed', '123456', 'ahmed-maroof', '1');
INSERT INTO `users` (`id`, `balance`, `email`, `name`, `password`, `username`, `role_id`) VALUES ('2', '1500', 'khaled@gmail.com', 'khaled', '123456', 'khaleduser', '1');
INSERT INTO `users` (`id`, `balance`, `email`, `name`, `password`, `username`, `role_id`) VALUES ('3', '1500', 'admin@gmail.com', 'admin', '123456', 'admin', '3');

INSERT INTO `bill` (`id`, `name`, `value`, `user_id`,`status`) VALUES ('1', 'bill1', '250', '1', 0);
INSERT INTO `bill` (`id`, `name`, `value`, `user_id`,`status`) VALUES ('2', 'bill2', '300', '1', 0 );
INSERT INTO `bill` (`id`, `name`, `value`, `user_id`,`status`) VALUES ('3', 'bill3', '100', '2', 0 );
INSERT INTO `bill` (`id`, `name`, `value`, `user_id`,`status`) VALUES ('4', 'bill4', '25', '2', 0 );