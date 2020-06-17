DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstName VARCHAR(250) NOT NULL,
  lastName VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);

INSERT INTO customer (firstName,lastName,email) VALUES('customer1','customer11','customer1@gmail.com'),('customer2','customer22','customer2@gmail.com'),('customer3','customer33','customer3@gmail.com');