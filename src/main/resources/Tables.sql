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
INSERT INTO Seller (seller_id, name)
VALUES
(1, 'Jerry'),
(2, 'Bliss'),
(3, 'Iry'),
(4, 'Justin');

INSERT INTO Product (product_id, productName, price, sold_by) VALUES
(1, 'Television', 750, 1),
(2, 'Car', 45000, 2),
(3, 'Ipad', 500, 3),
(4, 'Ps5', 550, 4);