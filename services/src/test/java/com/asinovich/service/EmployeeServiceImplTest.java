package com.asinovich.service;

import com.asinovich.domain.Employee;
import com.asinovich.dto.EmployeeDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
@RunWith (MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    private static final int INEXISTENT_USER_ID = 2;
    private Employee employeeNico = new Employee("Nico", "Asinovich");
    private Employee employeeChan = new Employee("Chan", "Li");
    private Employee employeeGary = new Employee("Gary", "Van");

    @Mock
    EmployeeDTO employeeDTO;
    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void testGetIdSuccessfully() {
//        when(employeeDTO.getId(String.valueOf(employeeNico.getId()))).thenReturn(employeeNico);
    }
}
