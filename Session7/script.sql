create database GamingHouse;
use GamingHouse;
-- Computer: quản lý thông tin về các máy
create table Computers(
	id varchar(36) primary key not null,
    name varchar(250) unique not null,
    price float not null,
    status bit
);
select * from computers;
-- Service: quản lý thông tin về các dịch vụ đi kèm
create table Services(
	id varchar(36) primary key not null,
    name nvarchar(250) unique not null,
    price float,
    status bit
);
-- Order: Lưu thông tin giờ chơi, giá của khách sử dụng DV
create table Orders(
	id varchar(36) primary key not null,
    computerId varchar(36) not null,
    startTime datetime not null,
    totalTime float,
    pricePerHours float,
    created datetime,
    status bit
);
-- OrderDetails: Chi tiết các dịch vụ sử dụng
create table OrderDetails(
	id varchar(36) primary key not null,
    orderId varchar(36) not null,
    serviceId varchar(36) not null,
    quantity int not null,
    price float not null
);