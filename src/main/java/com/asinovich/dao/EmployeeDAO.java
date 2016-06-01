package com.asinovich.dao;


import com.asinovich.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Реализация поведения Работника
 *
 * @author Nicolas Asinovich.
 */
public interface EmployeeDAO extends CrudRepository<Employee, Long> {

    List<Employee> findAll();

    void saveAndFlush(Employee employee);

}
