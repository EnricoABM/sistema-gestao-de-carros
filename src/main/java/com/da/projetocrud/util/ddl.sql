create database projetoda;

use projetoda;

create table carro (
    id serial,
    marca varchar (20),
    modelo varchar (50),
    ano int (4),
    motor varchar (20),
    placa varchar (7),
    dono varchar (50),
    cnh varchar (11),
    telefone varchar (12),
    endereco varchar (100)
);