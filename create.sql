create table IF NOT EXISTS ODONTOLOGO(ID int auto_increment primary key,nombre varchar(255),apellido varchar (255),matricula varchar (255));

create table IF NOT EXISTS PACIENTES(ID int auto_increment primary key,nombre varchar(255),apellido varchar (255),edad int, DNI int, fechaAlta TIMESTAMP WITHOUT TIME ZONE);