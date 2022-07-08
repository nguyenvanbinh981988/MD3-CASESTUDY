create database caseStudy;
use caseStudy;

create table sellProduct(
id int primary key auto_increment not null,
name varchar(120) not null,
price int(20) not null,
discount float default("0"),
importAmount int default("0"),
exportAmount int default("0"),
inventory int ,
properties text
);

create table customer(
id int primary key auto_increment not null,
name varchar(120) not null,
bankcard varchar(120) not null,
rankguest varchar(20) not null,
address varchar(100) not null
);

create table admin(
id int primary key auto_increment not null,
name varchar(100) not null,
position varchar(50)
);

create table sellList(
id int primary key auto_increment not null,
exportAmount int default("1"),
customerId int, foreign key (customerId) references customer(id),
sellProductId int, foreign key(sellProductId) references sellProduct(id),
adminId int, foreign key(adminId) references admin(id),
statusCustomer varchar(50),
statusAdmin varchar(50)
);


 




