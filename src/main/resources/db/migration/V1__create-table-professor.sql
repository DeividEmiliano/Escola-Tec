create table professor(

id bigint not null auto_increment,
nome varchar(100) not null,
email varchar(100) not null unique,
telefone varchar(11),
especialidade varchar(100) not null,


primary key(id)

);