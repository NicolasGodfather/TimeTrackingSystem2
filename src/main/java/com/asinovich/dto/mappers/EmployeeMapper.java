package com.asinovich.dto.mappers;

import com.asinovich.domain.Employee;
import com.asinovich.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

/**
 * Сделай несколько классов мапперов (с @Component). Например UserMapper который будет просто
 * переносить данные из dto в domain и наоборот. Затем просто инжекть их в ConverterDTOToDomain.
 * Так у тебя упроститься логика. Думаю даже было бы не плохо часть логики перенести из ConverterDTOToDomain
 * перенести в сервисные классы. Возможно даже избавиться от ConverterDTOToDomain. Не нужно в самих дтошках
 * (в конструкторе) брать поля из доменного класса и сэтить в дто. Пусть этим займутся мапперы, а конструктор
 * останется пустым. DTO для переноса данных, а ты в них пихаешь логику мапперов.
 *
 * Мапер это просто класс, в котором у тебя есть методы, которые просто переносят данные из dto в
 * domain и на оборот (то что ты делаешь в конструкторе dto). Просто пометь эти классы @Component и
 * инжекть там где это нужно. Избавься от этой логики в dto.
 * У тебя должно быть по одному маперу на каждый доменный класс. Примера у меня нет. Эти классы придельно просты.
 *
 * Реализация конвертации из dto в domain и наоборот
 *
 * @author Nicolas Asinovich.
 */
@Component
public class EmployeeMapper {

    /**
     * Convert Employee
     */
    public Employee convertEmployeeDTOToTheEmployee (EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        if (employeeDTO.getId() == null) {
            setEmployee(employeeDTO, employee);
        } else {
            employee.setId(Long.parseLong(employeeDTO.getId()));
            setEmployee(employeeDTO, employee);
        }
        return employee;
    }

    private void setEmployee (EmployeeDTO employeeDTO, Employee employee) {
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setPosition(employeeDTO.getPosition());
    }

    public EmployeeDTO convertEmployeeToTheEmployeeDTO (Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();

// TODO:  нужна ли здесь проверка, и правильно ли проверяю id типа long? также и в последующих маперах где есть long id
        if (String.valueOf(employee.getId()).isEmpty()) {
            setEmployeeDTO(employeeDTO, employee);
        } else {
            employeeDTO.setId(String.valueOf(employee.getId()));
            setEmployeeDTO(employeeDTO, employee);
        }
        return employeeDTO;
    }

    private void setEmployeeDTO (EmployeeDTO employeeDTO, Employee employee) {
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setPosition(employee.getPosition());
    }
}
