drop table if exists users;
drop table if exists roles;
drop table if exists user_roles;

create table users
(id number(20) not null primary key auto_increment,
full_name varchar(60),
password varchar(255),
phone_number varchar(8) unique,
user_name varchar(20) unique);

create table roles
(id number(20) not null primary key auto_increment,
name varchar(50) unique);