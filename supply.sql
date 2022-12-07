create database supply;
use supply;
show tables;
create table User(
emailId varchar(255) PRIMARY KEY,
userName varchar(255),
pass varchar(255),
userType varchar(255));	
select * from User;
Insert Into User values("robin@gmail.com","robin garg","1234","buyer");
Insert Into User(UserName,emailId,pass,userType) values("abhay singh","abhay@gmail.com","1234","seller");
create table poduct(
productId int PRIMARY KEY,
productName varchar(255),
price float,
sellerId varchar(255),
foreign key(sellerId) references user(emailId));
Insert into product values(1,"car",234516,"abhay@gmail.com");
