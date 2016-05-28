package com.asinovich.dto;

import com.asinovich.domain.Employee;
import org.springframework.stereotype.Component;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
@Component
public class ConverterDTOToDomain {

    public Employee convertEmployeeDTOToTheEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        if (employeeDTO.getId() == null) {
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setPosition(employeeDTO.getPosition());
        } else {
            employee.setId(Long.parseLong(employeeDTO.getId()));
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setPosition(employeeDTO.getPosition());
        }
        return employee;
    }
}
