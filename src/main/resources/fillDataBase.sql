insert into time.employee (id, name, surname, position) value('1', 'Chuck', 'Norris', 'manager' );
insert into time.employee (id, name, surname, position) value('2', 'Jackie', 'Chan', 'manager' );
insert into time.employee (id, name, surname, position) value('3', 'Nicolas', 'Asinovich', 'developer' );
insert into time.employee (id, name, surname, position) value('4','Alina', 'Rosolko', 'contextualSpec' );
insert into time.employee (id, name, surname, position) value('5','Anna', 'Rosolko', 'designer' );
insert into time.employee (id, name, surname, position) value('6','Arkadiy', 'Kuznetsov', 'developer' );
insert into time.employee (id, name, surname, position) value('7','Dmitriy', 'Stolbunov', 'developer' );
insert into time.employee (id, name, surname, position) value('8','Aleksandr', 'Budnikov' , 'developer' );

insert into time.project (projectName, responsibleEmployeeId) values ( 'Clinic' , '1');
insert into time.project (projectName, responsibleEmployeeId) values ( 'AutoService', '2');
insert into time.project (projectName, responsibleEmployeeId) values ( 'TV-NEWS', '7');
insert into time.project (projectName, responsibleEmployeeId) values ( 'Family Health', '3');

insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'add new functional', '2', '3' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'make design new pages', '1', '5' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'make advt', '4', '4' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'come up new functional', '2', '6' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'develop new system', '3', '7' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'develop new system', '4', '8' );
insert into time.task (taskName, taskOfProjectId, responsibleEmployeeId) values ( 'implement all', '3', '3' );

