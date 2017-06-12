DROP DATABASE IF EXISTS t05;

create database t05;
  use t05;

  create table users (
    id int not null auto_increment unique primary key,
    username varchar(155) unique not null,
    password varchar(255) unique not null
  );

  insert into users(username, password) values("admin", "admin");


create table faves (
  id int not null auto_increment unique primary key,
  name varchar(255),
  belongsTo int,
  foreign key (belongsTo) references users(id)
);
