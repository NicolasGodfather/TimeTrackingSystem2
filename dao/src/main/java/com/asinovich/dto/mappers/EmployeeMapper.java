package com.asinovich.dto.mappers;

import com.asinovich.domain.Employee;
import com.asinovich.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

/**
 * Реализация конвертации из dto в domain и наоборот
 *
 * @author Nicolas Asinovich.
 */
@Component
public class EmployeeMapper {

    /**
     * Convert Employee
     */
    public Employee convertEmployeeDTOToEmployee (EmployeeDTO employeeDTO) {
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
