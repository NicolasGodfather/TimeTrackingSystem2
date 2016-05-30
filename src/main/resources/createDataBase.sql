CREATE DATABASE IF NOT EXISTS time;
USE time;

DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name varchar(45) NOT NULL,
  surname varchar(45) NOT NULL,
  position varchar (45) NOT NULL
);

DROP TABLE IF EXISTS project;
CREATE TABLE project (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  projectName varchar(45) NOT NULL,
  responsibleEmployeeId varchar(45) NOT NULL
#   FOREIGN KEY (responsibleEmployeeId) REFERENCES employee (id)
);

DROP TABLE IF EXISTS task;
CREATE TABLE task (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  taskName varchar(45) NOT NULL,
  responsibleEmployee varchar(45) NOT NULL
#     FOREIGN KEY (responsibleEmployee) REFERENCES employee (id)
);

DROP TABLE IF EXISTS recordSpentTime;
CREATE TABLE recordSpentTime (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  employeeName varchar(45) NOT NULL,
  #   FOREIGN KEY (employee) REFERENCES employee (id),
  calendarInsertRecord varchar(45) NOT NULL,
  numberOfHour varchar(45) NOT NULL
);


# ссылки закоментировал, с ними не загружается в бд
