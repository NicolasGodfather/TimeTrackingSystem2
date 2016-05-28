package com.asinovich.service;

import com.asinovich.dao.EmployeeDAO;
import com.asinovich.domain.Employee;
import com.asinovich.dto.ConverterDTOToDomain;
import com.asinovich.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
@Service
public class EmployeeServiceImpl implements  EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ConverterDTOToDomain converterDTOToDomain;

    @Transactional (readOnly = true)
    public EmployeeDTO getById (long id) {
        return new EmployeeDTO(employeeDAO.findOne(id));
    }

    @Transactional (readOnly = true)
    public List<EmployeeDTO> getAll () {
        List<Employee> employees = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
        for (Employee employee : employees) {
            employeeDTOs.add(new EmployeeDTO(employee));
        }
        return employeeDTOs;
    }

    @Transactional
    public void insert (EmployeeDTO employeeDTO) {
        employeeDAO.saveAndFlush(converterDTOToDomain.convertEmployeeDTOToTheEmployee(employeeDTO));
    }

    @Transactional
    public void update (EmployeeDTO employeeDTO) {
        employeeDAO.saveAndFlush(converterDTOToDomain.convertEmployeeDTOToTheEmployee(employeeDTO));
    }

    @Transactional
    public void deleteById (long id) {
        Employee employee = employeeDAO.findOne(id);
        employeeDAO.delete(employee);
    }
}
