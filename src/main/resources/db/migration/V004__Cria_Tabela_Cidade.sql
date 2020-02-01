CREATE TABLE `cidade` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) DEFAULT NULL,
    `estado_id` int(11) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

Alter Table cidade add constraint FK_cidade_estado 
foreign key(estado_id) references estado(id);

INSERT INTO `cidade` (`id`,`nome`,`estado_id`) VALUES (1,'Lençois Paulista',1);
INSERT INTO `cidade` (`id`,`nome`,`estado_id`) VALUES (2,'Macatuba',1);
INSERT INTO `cidade` (`id`,`nome`,`estado_id`) VALUES (3,'Rio de Janeiro',2);