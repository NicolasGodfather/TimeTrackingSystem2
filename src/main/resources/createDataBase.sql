CREATE DATABASE IF NOT EXISTS `time`;
USE `time`;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `position` varchar (45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `projectName` varchar(45) NOT NULL,
  `employee` varchar(45) DEFAULT NULL,
  #   FOREIGN KEY (`employee`) REFERENCES employee (`id`)  ON DELETE NO ACTION ON UPDATE NO ACTION,
  `listTask` varchar(45) DEFAULT NULL
  #   FOREIGN KEY (listTask) REFERENCES task (id)  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `taskName` varchar(45) NOT NULL,
  `employee` varchar(45) DEFAULT NULL,
  #   FOREIGN KEY (employee) REFERENCES employee (id)  ON DELETE NO ACTION ON UPDATE NO ACTION,
  `listRecordSpentTime` varchar(45) DEFAULT NULL
  #   FOREIGN KEY (listRecordSpentTime) REFERENCES recordSpentTime (id)  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `recordSpentTime`;
CREATE TABLE `recordSpentTime` (
  `id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `employee` varchar(45) NOT NULL,
  #   FOREIGN KEY (employee) REFERENCES employee (id),
  `calendarInsertRecord` varchar(45) DEFAULT NULL,
  `numberOfHour` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8;


# ссылки закоментировал, с ними не загружается в бд
