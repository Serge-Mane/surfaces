drop database if exists surfaces;

create database surfaces;

use surfaces;

create table point(
id int auto_increment primary key,
x int,
y int
);
 