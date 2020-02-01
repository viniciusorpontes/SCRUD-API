CREATE TABLE `cliente` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `nome` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `cpfoucnpj` varchar(255) NOT NULL,
    `telefone` varchar(255) NOT NULL,
    `logradouro` varchar(255) NOT NULL,
    `numero` varchar(255) NOT NULL,
    `complemento` varchar(255),
    `bairro` varchar(255) NOT NULL,
    `cep` varchar(255) NOT NULL,
	`cidade_id` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 	

Alter Table cliente add constraint FK_cliente_cidade
foreign key(cidade_id) references cidade(id);

INSERT INTO `cliente` (`id`,`nome`,`email`,`cpfOuCnpj`,`telefone`,`logradouro`,`numero`,`complemento`,`bairro`,
	`cep`,`cidade_id`) VALUES (1,'Vinicius Pontes','viniciuspontes@gmail.com','46066597850','998371897',
		'José Príncipe Penhafiel','183','','Jardim Príncipe','18682841',1);