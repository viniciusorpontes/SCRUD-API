CREATE TABLE `produto` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) DEFAULT NULL,
  	`preco` decimal(19,2) DEFAULT NULL,
  	`categoria_id` int(11) DEFAULT NULL,
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
  
  Alter Table produto add constraint FK_produto_categoria 
  foreign key(categoria_id) references categoria(id);
  
INSERT INTO `produto` (`id`,`nome`,`preco`,`categoria_id`) VALUES (1,'Mouse',39.90,1);
INSERT INTO `produto` (`id`,`nome`,`preco`,`categoria_id`) VALUES (2,'Mesa para computador',357.80,2);
INSERT INTO `produto` (`id`,`nome`,`preco`,`categoria_id`) VALUES (3,'Desodorante Avanço',5.20,3);