CREATE TABLE `estado` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `estado` (`id`,`nome`) VALUES (1,'São Paulo');
INSERT INTO `estado` (`id`,`nome`) VALUES (2,'Rio de Janeiro');
INSERT INTO `estado` (`id`,`nome`) VALUES (3,'Paraná');