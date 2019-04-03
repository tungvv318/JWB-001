CREATE DATABASE my_classicmodels3;
USE my_classicmodels3;
CREATE TABLE orders(
	orderNumber INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	orderDate DATETIME NOT NULL,
	requiredDate DATETIME NOT NULL,
	shippedDate DATETIME,
	status VARCHAR(15) NOT NULL,
	comment TEXT,
	customerNumber INT(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE productlines(
	productLine VARCHAR(50) NOT NULL PRIMARY KEY,
	textDescription VARCHAR(4000),
	htmlDescription MEDIUMTEXT,
	image MEDIUMBLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE orderdetails(
	orderNumber INT(11) NOT NULL AUTO_INCREMENT,
	productCode VARCHAR(15) NOT NULL,
	quantityOrdered INT(11) NOT NULL,
	priceEach DOUBLE NOT NULL,
	orderLineNumber SMALLINT(6),
	PRIMARY KEY(orderNumber,productCode)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE products(
	productCode VARCHAR(15) NOT NULL,
	productName VARCHAR(70) NOT NULL,
	productLine VARCHAR(50) NOT NULL,
	productScale VARCHAR(10) NOT NULL,
	producVendor  VARCHAR(50) NOT NULL,
	productDescription TEXT NOT NULL,
	quantityInStock SMALLINT NOT NULL,
	buyPrice DOUBLE NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE products ADD
	FOREIGN KEY (productLine) REFERENCES productlines(productLine) ON DELETE RESTRICT ON UPDATE CASCADE;
