package com.asinovich.dto;

import com.asinovich.domain.Employee;

/**
 * Реализация
 *
 * @author Nicolas Asinovich.
 */
public class EmployeeDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String position;

    public EmployeeDTO () {
    }

    public EmployeeDTO (Employee employee) {
        this.id = Long.toString(employee.getId());
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.position = employee.getPosition();
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }
}
