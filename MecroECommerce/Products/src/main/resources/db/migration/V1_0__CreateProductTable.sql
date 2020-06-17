
CREATE TABLE `productmanagement`.`product` (
  `id`  INT AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`));
INSERT INTO `productmanagement`.`product` (`name`, `price`) VALUES ('product1', '150');
INSERT INTO `productmanagement`.`product` (`name`, `price`) VALUES ('product2', '200');
INSERT INTO `productmanagement`.`product` (`name`, `price`) VALUES ('product3', '502');