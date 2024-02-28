DROP TABLE Seller IF EXISTS;
CREATE TABLE Seller  (
seller_id int primary key,
name varchar(50) NOT NULL);

DROP TABLE Product IF EXISTS;
CREATE TABLE Product (
    product_id int primary key,
    productName varchar(255) not null,
    price int,
    sold_by int references Seller(seller_id)
);
