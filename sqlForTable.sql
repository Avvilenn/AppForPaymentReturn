DROP DATABASE IF EXISTS student_orders;

CREATE DATABASE student_orders DEFAULT CHARACTER SET 'utf8';

USE student_orders;

CREATE TABLE orders
(
  orders_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email TEXT,
 husband_surName TEXT,
 husband_givenName TEXT,
 husband_patronymic TEXT,
 husband_dateOfBirth DATE,
 husband_passportSeria TEXT,
 husband_passportNumber TEXT,
 husband_passportDateIssue DATE,
 husband_passportDateExpire DATE,
 wife_surName TEXT,
 wife_givenName TEXT,
 wife_patronymic TEXT,
 wife_dateOfBirth DATE,
 wife_passportSeria TEXT,
 wife_passportNumber TEXT,
 wife_passportDateIssue DATE,
 wife_passportDateExpire DATE,
 grnAnswer BOOLEAN,
 zagsAnswer BOOLEAN,
 studentAnswer BOOLEAN,
 verification TEXT
  );

 CREATE TABLE children
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 order_id INT NOT NULL,
 surName TEXT,
 givenName TEXT,
 patronymic TEXT,
 dateOfBirth DATE,
 birthDocument TEXT,
 FOREIGN KEY (order_id) REFERENCES orders(orders_id)
  );

  CREATE TABLE log_in
(
 log_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 email TEXT,
 password TEXT
);

