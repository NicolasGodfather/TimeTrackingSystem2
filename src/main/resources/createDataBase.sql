CREATE DATABASE IF NOT EXISTS time;
USE time;

DROP TABLE IF EXISTS spentTime;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS employee;


CREATE TABLE employee (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name varchar(45)                  NOT NULL,
  surname varchar(45)               NOT NULL,
  position varchar (45)             NOT NULL
);

CREATE TABLE project (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  projectName varchar(45)           NOT NULL,
  responsibleEmployeeId INT         NOT NULL REFERENCES employee (id)
);

CREATE TABLE task (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  taskName varchar(45)              NOT NULL,
  taskOfProjectId INT               NOT NULL REFERENCES project  (id),
  responsibleEmployeeId INT         NOT NULL REFERENCES employee (id)
);

CREATE TABLE spentTime (
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  calendarInsertRecord varchar(45)  NOT NULL,
  numberOfHour varchar(45)          NOT NULL,
  employeeNameId INT                NOT NULL REFERENCES employee (id),
  nameTaskId INT                    NOT NULL REFERENCES task     (id)
);

# SELECT * FROM project LEFT JOIN employee USING(id);



