package com.asinovich.service.impl;

import com.asinovich.dao.EmployeeDAO;
import com.asinovich.domain.Employee;
import com.asinovich.dto.EmployeeDTO;
import com.asinovich.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeDTOToTheEmployee;
import static com.asinovich.dto.mappers.EmployeeMapper.convertEmployeeToTheEmployeeDTO;

/**
 * Реализация сервис слоя
 *
 * @author Nicolas Asinovich.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

//    private ConverterDTOToDomain converterDTOToDomain;


    @Transactional (readOnly = true)
    public EmployeeDTO getById (long id) {
//        return new EmployeeDTO(employeeDAO.findOne(id));
        return convertEmployeeToTheEmployeeDTO(employeeDAO.findOne(id));
    }

    @Transactional (readOnly = true)
    public List<EmployeeDTO> getAll () {
        List<Employee> employees = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
        for (Employee employee : employees) {
//            employeeDTOs.add(new EmployeeDTO(employee));
            employeeDTOs.add(convertEmployeeToTheEmployeeDTO(employee));
        }
        return employeeDTOs;
    }

    @Transactional
    public void insert (EmployeeDTO employeeDTO) {
//        employeeDAO.saveAndFlush(converterDTOToDomain.convertEmployeeDTOToTheEmployee(employeeDTO));
        employeeDAO.saveAndFlush(convertEmployeeDTOToTheEmployee(employeeDTO));
    }

    @Transactional
    public void update (EmployeeDTO employeeDTO) {
//        employeeDAO.saveAndFlush(converterDTOToDomain.convertEmployeeDTOToTheEmployee(employeeDTO));
        employeeDAO.saveAndFlush(convertEmployeeDTOToTheEmployee(employeeDTO));
    }

    @Transactional
    public void deleteById (long id) {
        Employee employee = employeeDAO.findOne(id);
        employeeDAO.delete(employee);
    }
}
