drop database if exists surfaces;

create database surfaces;

use surfaces;

create table figures(
id int auto_increment primary key,
name varchar(50)
);

create table points(
id int auto_increment primary key,
x int,
y int,
figure_id int,
foreign key (figure_id) references figure(id)
);
