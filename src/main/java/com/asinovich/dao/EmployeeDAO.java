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

    Employee findOne(Long id);

    List<Employee> findAll();

    void saveAndFlush(Employee employee);

    void delete(Employee employee);
}
