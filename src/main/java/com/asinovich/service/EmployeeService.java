package com.asinovich.service;

import com.asinovich.dto.EmployeeDTO;

import java.util.List;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public interface EmployeeService {

    EmployeeDTO getById(long id);

    List<EmployeeDTO> getAll();

    void insert(EmployeeDTO employeeDTO);

    void update(EmployeeDTO employeeDTO);

    void deleteById(long id);
}
