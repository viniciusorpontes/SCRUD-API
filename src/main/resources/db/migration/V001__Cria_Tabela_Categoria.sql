CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `categoria` (`id`,`nome`) VALUES (1,'Informattica');
INSERT INTO `categoria` (`id`,`nome`) VALUES (2,'Moveis para escritorio');
INSERT INTO `categoria` (`id`,`nome`) VALUES (3,'Perfumaria');